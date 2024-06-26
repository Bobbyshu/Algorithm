package Doc.InternDoc.Enovia;

import jakarta.json.*;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


// this file is only for test FileGenerator
// only test en and fr
public class testMainHardCodeVersion {
    public static void main(String[] args) {
        try {
            Properties fileProp = new Properties();
            fileProp.load(new FileReader("enoDocumentControl.properties"));

            // Map each language
            // <FR -> XXX_FR.PROP》
            Map<String, Properties> map = new HashMap<>();
            // Load only English and French properties
            map.put("en", new Properties());
            map.get("en").load(new FileInputStream("enoDocumentControlStringResource_en.properties"));
            map.put("fr", new Properties());
            map.get("fr").load(new FileInputStream("enoDocumentControlStringResource_fr.properties"));

            // Create JSON array builder
            JsonArrayBuilder fileCategoriesArrayBuilder = Json.createArrayBuilder();

            String p = fileProp.getProperty("enoDocumentControl.FileCategory.RangeValues");
            String[] prevProp = p.trim().split(",");
            System.out.println(Arrays.toString(prevProp));
            for (String pre : prevProp) {
                JsonObjectBuilder objBuilder = Json.createObjectBuilder();
                objBuilder.add("name", pre.trim());

                JsonArrayBuilder transArrayBuilder = Json.createArrayBuilder();

                // Get English translation
                Properties prop = map.get("en");
                String translation = prop.getProperty("enoDocumentControl.Range.File_Category." + pre.trim().replace(' ', '_'));
                if (translation != null) {
                    JsonObjectBuilder transObjBuilder = Json.createObjectBuilder();
                    transObjBuilder.add("en", translation);
                    transArrayBuilder.add(transObjBuilder);
                }

                // Get French translation
                Properties frProp = map.get("fr");
                String frTranslation = frProp.getProperty("enoDocumentControl.Range.File_Category." + pre.trim().replace(' ', '_'));
                System.out.println(pre);
                System.out.println(frTranslation);
                if (frTranslation != null) {
                    JsonObjectBuilder transObjBuilder = Json.createObjectBuilder();
                    transObjBuilder.add("fr", frTranslation);
                    transArrayBuilder.add(transObjBuilder);
                }

                objBuilder.add("translations", transArrayBuilder);
                fileCategoriesArrayBuilder.add(objBuilder);
            }

            JsonObject jsonObj = Json.createObjectBuilder()
                    .add("filecategories", fileCategoriesArrayBuilder)
                    .build();

            try (FileWriter fileWriter = new FileWriter("target.json");
                 JsonWriter jsonWriter = Json.createWriter(fileWriter)) {
                jsonWriter.writeObject(jsonObj);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
