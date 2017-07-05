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

import org.jdom.Attribute;

public class SlubAttribute
{

    private Attribute myAttribute = null;
    private boolean flagSameID = false;

    @SuppressWarnings("unused")
    private SlubAttribute()
    {

    }

    public SlubAttribute(Attribute att)
    {
        myAttribute = att;
    }

    public boolean equals(Attribute att)
    {

        if (!att.getName().equals(myAttribute.getName()))
        {
            return false;
        }

        if (!att.getNamespace().equals(myAttribute.getNamespace()))
        {
            return false;
        }

        flagSameID = true;

        if (!att.getValue().equals(myAttribute.getValue()))
        {
            return false;
        }

        return true;
    }

    public boolean hasSameID(){
        return flagSameID;
    }

    public Attribute getAttribute(){
        return myAttribute;
    }
}
