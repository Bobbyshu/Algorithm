package Doc.InternDoc.Enovia;

public class check {
//    public void convertFileCategoriesToJSON(Context context, String args[]) throws Exception {
//        try {
//            String[] options = {"en", "fr", "de", "ja", "es", "it", "zh"};
//            // <languageCode, languageProperties>
//            Map<String, String> map = new HashMap<>();
//            for (String s : options) {
//                // "en": "enoDocumentControlStringResource_en"
//                map.put(s, "enoDocumentControlStringResource" + "_" + s);
//            }
//
//            // Skip PDF,Attachment,Digital Signature,Wet Signature,Heterogeneous,
//            // Didn't find static const
//            List<String> categoryValues = DCUtil.getCategoryRangeValues(context, "enoDocumentControl.FileCategory.RangeValues");
//            JsonArrayBuilder fileCategoriesArrayBuilder = Json.createArrayBuilder();
//
//            for (String pre : categoryValues) {
//                JsonObjectBuilder objBuilder = Json.createObjectBuilder();
//                objBuilder.add("name", pre.trim());
//
//                JsonArrayBuilder transArrayBuilder = Json.createArrayBuilder();
//                for (Map.Entry<String, String> entry : map.entrySet()) {
//                    String languageCode = entry.getKey();
//                    String prop = entry.getValue();
//                    List<String> translation = DCUtil.getCategoryRangeValues(context, "enoDocumentControl.Range.File_Category." + pre.trim().replace(' ', '_'));
//
//                    if (!"".equals(translation.get(0))) {
//                        JsonObjectBuilder transObjBuilder = Json.createObjectBuilder();
//                        transObjBuilder.add(languageCode, translation.get(0));
//                        transArrayBuilder.add(transObjBuilder);
//                    }
//                }
//
//                objBuilder.add("translations", transArrayBuilder);
//                fileCategoriesArrayBuilder.add(objBuilder);
//            }
//
//            // write new JSON file
//            JsonObject jsonObj = Json.createObjectBuilder()
//                    .add("filecategories", fileCategoriesArrayBuilder)
//                    .build();
//
//            try (FileWriter fileWriter = new FileWriter("target.json");
//                 JsonWriter jsonWriter = Json.createWriter(fileWriter)) {
//                jsonWriter.writeObject(jsonObj);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception();
//        }
//    }
}
