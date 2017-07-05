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
 * ugh.dl.exceptions / DocStructHasNoTypeException.java
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
 * <p>
 * Exception is thrown, if metadata should be added, but the DocStruct has no
 * DocStructType.
 * </p>
 *
 * @author Markus Enders
 * @version 2009-09-24
 * @since 2005-03-09
 ******************************************************************************/

public class DocStructHasNoTypeException extends RuntimeException {

    private static final long    serialVersionUID    = -1950082217522786783L;

    /***************************************************************************
     * Default constructor.
     **************************************************************************/
    public DocStructHasNoTypeException() {
        super();
    }

    /***************************************************************************
     * @param inMessage
     **************************************************************************/
    public DocStructHasNoTypeException(String inMessage) {
        super(inMessage);
    }

    /***************************************************************************
     * @param exp
     **************************************************************************/
    public DocStructHasNoTypeException(Exception e) {
        super(e);
    }

    /***************************************************************************
     * @param inMessage
     * @param exp
     **************************************************************************/
    public DocStructHasNoTypeException(String inMessage, Exception e) {
        super(inMessage, e);
    }

}