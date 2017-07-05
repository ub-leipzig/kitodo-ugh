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
package converter.processing;

/************************************************************************************
 * general Exception ImageLib-API
 *
 * @version 02.01.2009
 * @author Steffen Hankiewicz
 * @author Markus Enders
 ************************************************************************************/
public class ContentLibException extends Exception {

    private static final long serialVersionUID = 4277888305577041996L;

    public ContentLibException(){
        super();
    }

    public ContentLibException(String inMessage){
        super(inMessage);
    }

    public ContentLibException(Throwable incause){
        super(incause);
    }

    public ContentLibException(String inMessage, Throwable incause){
        super(inMessage, incause);
    }

}
