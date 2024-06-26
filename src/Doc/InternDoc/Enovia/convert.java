package Doc.InternDoc.Enovia;

public class convert {
    public static void main(String[] args) {
//        try {
//            Properties fileProp = new Properties();
//            fileProp.load(new FileReader("enoDocumentControl.properties"));
//
//            Map<String, String> map = new HashMap<>();
//            String[] options = {"en", "fr", "de", "ja", "es", "it", "zh"};
//            for (String s : options) {
//                map.put(s, "enoDocumentControlStringResource" + "_" + s);
//            }
//
//            JsonArrayBuilder fileCategoriesArrayBuilder = Json.createArrayBuilder();
//
//            String p = fileProp.getProperty("enoDocumentControl.FileCategory.RangeValues");
//            String[] prevProp = p.trim().split(",");
//            for (String pre : prevProp) {
//                JsonObjectBuilder objBuilder = Json.createObjectBuilder();
//                objBuilder.add("name", pre.trim());
//
//                JsonArrayBuilder transArrayBuilder = Json.createArrayBuilder();
//
//                for (Map.Entry<String, String> entry : map.entrySet()) {
//                    String language = entry.getKey();
//                    String translation = prop.getProperty("enoDocumentControl.Range.File_Category." + pre.trim().replace(' ', '_'));
//
//                    if (translation != null) {
//                        JsonObjectBuilder transObjBuilder = Json.createObjectBuilder();
//                        transObjBuilder.add(language, translation);
//                        transArrayBuilder.add(transObjBuilder);
//                    }
//                }
//
//                objBuilder.add("translations", transArrayBuilder);
//                fileCategoriesArrayBuilder.add(objBuilder);
//            }
//
//            JsonObject jsonObj = Json.createObjectBuilder()
//                    .add("filecategories", fileCategoriesArrayBuilder)
//                    .build();
//
//            FileWriter fileWriter = new FileWriter("target.json");
//            JsonWriter jsonWriter = Json.createWriter(fileWriter);
//            jsonWriter.writeObject(jsonObj);
//            fileWriter.write("\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
