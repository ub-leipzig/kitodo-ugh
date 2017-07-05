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
 * interface for ...
 *
 * @version 06.01.2009
 * @author Steffen Hankiewicz
 * @author Markus Enders
 ************************************************************************************/
public interface Validatable{

    public void validate() throws ContentLibException;

    public void setBaseFolder(String path);
    public void setID(String id);
    public void setSearchString(String searchExpression);

}
