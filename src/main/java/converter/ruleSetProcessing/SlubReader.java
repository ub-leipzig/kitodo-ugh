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
package converter.ruleSetProcessing;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;

public class SlubReader extends RulesetReader {

    SlubElement mySlubRoot = null;

    private SlubReader() {
        super("");
    }

    public SlubReader(String filePath) {
        super(filePath);
        super.logger.info("Slub ruleset path set as '" + filePath + "'");

        SlubIntegrity.createWatch("MetadataType", "Name");
        SlubIntegrity.createWatch("DocStrctType", "Name");
        SlubIntegrity.createWatch("Metadata", "Name");
        SlubIntegrity.createWatch("Person", "Name");

        // TODO there may be more elements to be added to the watch list (pica, MODS/METS)
        SlubIntegrity.createWatch("Metadata", "InternalName");
        SlubIntegrity.createWatch("DocStruct", "Name");
    }

    public void compare(ManuscriptReader mr) throws JDOMException, IOException {

        //get a deep clone of the root element, for manipulation without
        //effecting the original tree
        Element manuscriptRoot = (Element) mr.getDocument().getRootElement()
                .clone();

        //now create a SlubElement from the slub.xml root Element to start the compare procedure
        mySlubRoot = new SlubElement(super.getDocument().getRootElement());

        // add those element names which you would like to keep as a unit if they differ
        //those not added will loose equal child elements

        //now initiate the comparism process by feeding the clone of the manuscript root
        //into the SlubElement enhanced slubRoot
        if (!mySlubRoot.equals(manuscriptRoot)) {
            super.logger.info("manuscript.xml differs from slub.xml");
        } else {
            super.logger.info("manuscript.xml is equal to slub.xml");
        }

    }

    public Document getDiffDocument() {
        Document doc = new Document();
        if (mySlubRoot.hasDiffs()) {
            doc.addContent(mySlubRoot.getJDOMElement().detach());
            System.out.println(doc);
        }
        return doc;
    }
}
