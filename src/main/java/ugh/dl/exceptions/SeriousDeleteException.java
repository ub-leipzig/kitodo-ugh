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
package ugh.dl.exceptions;

/*******************************************************************************
 * ugh.dl.exceptions / SeriousDeleteException.java
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
 * along with this library. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

/*******************************************************************************
 * @author Markus Enders
 * @version 2009-09-24
 ******************************************************************************/

public class SeriousDeleteException extends UGHException {

    private static final long    serialVersionUID    = -6166668296450504223L;

    /***************************************************************************
     * Default constructor.
     **************************************************************************/
    public SeriousDeleteException() {
        super();
    }

    /***************************************************************************
     * @param inReason
     **************************************************************************/
    public SeriousDeleteException(String inReason) {
        super(inReason);
    }

    /***************************************************************************
     * @param e
     **************************************************************************/
    public SeriousDeleteException(Exception e) {
        super(e);
    }

    /***************************************************************************
     * @param inReason
     * @param e
     **************************************************************************/
    public SeriousDeleteException(String inReason, Exception e) {
        super(inReason, e);
    }

}
