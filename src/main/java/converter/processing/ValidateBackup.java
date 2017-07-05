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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ValidateBackup implements Validatable {

    String myID = null;
    String myBaseFolder = null;



    public void setBaseFolder(String path) {
        myBaseFolder = path;
    }

    public void setID(String id) {
        myID = id;
    }

    public void setSearchString(String searchExpression) {

    }

    public void validate() throws ContentLibException {
        FileReader f = null;
        try {
            f = new FileReader(myBaseFolder + myID + "/meta.xml.bak");
            if (f.read() > 1) {
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new ContentLibException("Validate Error - backup of metafile not found, inconsistent data",e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new ContentLibException("Validate Error - backup of metafile not found, inconsistent data",e);
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException e) {
                }
            }
        }
    }

}
