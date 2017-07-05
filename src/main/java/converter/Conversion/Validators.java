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
package converter.Conversion;

import java.io.File;
import java.io.IOException;

import org.jdom.JDOMException;

import ugh.dl.DigitalDocument;

public class Validators {


    public Boolean getEqualsValidation(DigitalDocument digDoc1, DigitalDocument digDoc2){
        return digDoc1.equals(digDoc2);
    }

    public Boolean getFileStringValidation(File fileA, File fileB) throws IOException{
        return FileCompare.filesSameContent(fileA, fileB);
    }

    public Boolean getFileStringValidation(String fileA, String fileB) throws IOException{
        return FileCompare.filesSameContent(fileA, fileB);
    }

    public Boolean getTokenizerValidation(File fileA, File fileB) throws JDOMException, IOException{
        return FileCompare.getTokenizerValidation(fileA, fileB);
    }


}
