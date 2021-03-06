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
 * ugh.dl.exceptions / IncompletePersonObjectException.java
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
 * This exception is thrown, when you are dealing with an incomplete
 * <code>Person</code> object. E.g. each object of this kind must have a
 * MetadataType. If this is NOT available, this exception may be thrown in some
 * methods, which need the type information.
 * </p>
 *
 * @author Markus Enders
 * @version 2009-09-24
 ******************************************************************************/

public class IncompletePersonObjectException extends RuntimeException {

    private static final long    serialVersionUID    = 3080339507475098186L;

    /***************************************************************************
     * Default constructor.
     **************************************************************************/
    public IncompletePersonObjectException() {
        super();
    }

    /***************************************************************************
     * @param inMessage
     **************************************************************************/
    public IncompletePersonObjectException(String inMessage) {
        super(inMessage);
    }

    /***************************************************************************
     * @param exp
     **************************************************************************/
    public IncompletePersonObjectException(Exception e) {
        super(e);
    }

    /***************************************************************************
     * @param inMessage
     * @param exp
     **************************************************************************/
    public IncompletePersonObjectException(String inMessage, Exception e) {
        super(inMessage, e);
    }

}
