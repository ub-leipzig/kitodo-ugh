/*
 *
 * (c) Kitodo. Key to digital objects e. V. <contact@kitodo.org>
 *
 * This file is part of the Kitodo project.
 *
 * It is licensed under GNU General Public License version 3 or later.
 *
 * For the full copyright and license information, please read the
 * GPL3-License.txt file that was distributed with this source code.
 */
package ugh.dl.fileformats.excel;

/*******************************************************************************
 * ugh.dl.fileformats.excel / PaginationSequence.java
 *
 * Copyright 2010 Center for Retrospective Digitization, Göttingen (GDZ)
 *
 * http://gdz.sub.uni-goettingen.de
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or (at your
 * option) any later version.
 *
 * This Library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library;. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

import java.util.LinkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ugh.dl.DigitalDocument;
import ugh.dl.DocStruct;
import ugh.dl.Metadata;
import ugh.dl.Prefs;
import ugh.dl.RomanNumeral;
import ugh.dl.exceptions.MetadataTypeNotAllowedException;
import ugh.dl.exceptions.TypeNotAllowedForParentException;

/*******************************************************************************
 * <p>
 * UGH - DMS tools and system utilities
 * </p>
 *
 * @author Markus Enders
 * @version 2009-10-27
 * @since 2004-05-21
 *
 ******************************************************************************/

public class PaginationSequence {

    private static final Logger    logger                = LogManager.getLogger(ugh.dl.DigitalDocument.class);

    protected int                physicalstart        = 0;
    protected int                physicalend            = 0;
    protected int                logcountedstart        = -1;
    protected int                logcountedend        = -1;
    protected int                lognotcountedstart    = -1;
    protected int                lognotcountedend    = -1;
    // Can be "1" for arabic or "R" for roman number; 1 is default.
    protected String            pageformatnumber    = "1";

    private ugh.dl.Prefs        mypreferences;

    /***************************************************************************
     * @param myprefs
     **************************************************************************/

    public PaginationSequence(Prefs myprefs) {
        this.mypreferences = myprefs;
    }

    /***************************************************************************
     * <p>
     * Convert the pages from this sequence to the physical document structure
     * entities these entities can be added to a digital document etc...
     * strucutre entities (DocStruct-objects) are returned as a LinkedList.
     * </p>
     *
     * @param digdoc
     * @return
     **************************************************************************/
    public LinkedList<DocStruct> ConvertToPhysicalStructure(
            DigitalDocument digdoc) {
        // Document structure type for the page.
        ugh.dl.DocStructType pagetype;
        // Type of metadata for storing pagenumbers etc.
        ugh.dl.MetadataType logpagenumbertype;
        // Tpye for storing physical pagenumber.
        ugh.dl.MetadataType physpagenumbertype;
        ugh.dl.DocStruct page;

        // Get DocStructType for page.
        pagetype = this.mypreferences.getDocStrctTypeByName("page");
        if (pagetype == null) {
            logger
                    .error("PaginationSequence.ConvertToPhysicalStructure: No DocStructType for 'page' available");
            return null;
        }

        // Get MetadataType for logical and physical page numbers.
        logpagenumbertype = this.mypreferences
                .getMetadataTypeByName("logicalPageNumber");
        physpagenumbertype = this.mypreferences
                .getMetadataTypeByName("physPageNumber");

        if (logpagenumbertype == null) {
            logger
                    .error("Ppagination sequences can't be calculated; 'logicalPageNumber' metadata type is NOT defined! This may cause corrupt data!");
        }
        if (physpagenumbertype == null) {
            logger
                    .error("Pagination sequences can't be calculated; 'physPageNumber' metadata type is NOT defined! This may cause corrupt data!");
        }

        // Ccreate a LinkedList containing all pages.
        LinkedList<DocStruct> allpages = new LinkedList<DocStruct>();

        for (int i = 0; i < (this.physicalend - this.physicalstart) + 1; i++) {

            Metadata logpagenumber;
            Metadata physpagenumber;
            // Create a page as a DocStruct instance.
            try {
                page = digdoc.createDocStruct(pagetype);

                logpagenumber = new Metadata(logpagenumbertype);
                physpagenumber = new Metadata(physpagenumbertype);
            } catch (TypeNotAllowedForParentException e) {
                logger
                        .error(
                                "PaginationSequence.ConvertToPhysicalStructure: Type not allowed as child!",
                                e);
                return null;
            } catch (MetadataTypeNotAllowedException e) {
                logger
                        .error(
                                "PaginationSequence.ConvertToPhysicalStructure: Type must not be null!",
                                e);
                return null;
            }

            // Set the value for the logical number, "uncounted"-value if it's
            // uncounted roman number, if it's roman etc...
            if ((this.logcountedstart != -1) && (this.lognotcountedstart < 0)) {
                // Counted start page.
                if (this.pageformatnumber.equals("1")) {
                    logpagenumber.setValue(Integer
                            .toString(this.logcountedstart + i));
                } else {
                    RomanNumeral romannumber = new RomanNumeral(
                            this.logcountedstart + i);
                    logpagenumber.setValue(romannumber.toString());
                }
            }
            if ((this.logcountedstart == 0) && (this.lognotcountedstart != 0)) {
                logpagenumber.setValue(" - ");
            }
            if ((this.logcountedstart == this.logcountedend)
                    && (this.lognotcountedstart != 0)
                    && (this.lognotcountedend != 0)) {
                logpagenumber.setValue(" - ");
            }

            // Set phyisical page number.
            physpagenumber.setValue(Integer.toString(this.physicalstart + i));
            try {
                // Add pagenumber as metadata.
                page.addMetadata(logpagenumber);
                page.addMetadata(physpagenumber);
            } catch (MetadataTypeNotAllowedException mtnaae) {
                logger.error(
                        "PaginationSequence: can't add pagenumbers to page!",
                        mtnaae);
                return null;
            }

            allpages.add(page);
        }

        return allpages;
    }

}
