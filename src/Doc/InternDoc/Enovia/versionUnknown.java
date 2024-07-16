//package Doc.InternDoc.Enovia;
//
//import jakarta.json.*;
//import jakarta.json.stream.JsonGenerator;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//
//public class versionUnknown {
//    public void convertFileCategoriesToJSON(Context context, String args[]) throws Exception {
//        try {
//            Map<String, Properties> languageMap = getLanguageMap();
//            List<String> categoryValues = DCUtil.getCategoryRangeValues(context, "enoDocumentControl.FileCategory.RangeValues");
//
//            JsonArray fileCategoriesArray = buildFileCategoriesArray(categoryValues, languageMap);
//
//            writeJsonToFile(fileCategoriesArray, "target.json");
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception();
//        }
//    }
//
//    /**
//     * return a map of language codes to their respective properties files.
//     * @return map for language version and properties
//     * @throws Exception if operation fails
//     */
//    private Map<String, Properties> getLanguageMap() throws Exception {
//        try {
//            String[] options = {"en", "fr", "de", "ja", "es", "it", "zh"};
//            Map<String, Properties> map = new HashMap<>();
//            for (String languageCode : options) {
//                Properties prop = loadPropertiesForLanguage(languageCode);
//                map.put(languageCode, prop);
//            }
//            return map;
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception();
//        }
//    }
//
//    /**
//     * Loads the properties file for a specific language.
//     * @param languageCode
//     * @return The properties object containing the translations for the specified language.
//     * @throws Exception if operation fails
//     */
//    private Properties loadPropertiesForLanguage(String languageCode) throws IOException {
//        Properties prop = new Properties();
//        File file = new File("enoDocumentControlStringResource_" + languageCode + ".properties");
//        if (file.exists()) {
//            try (FileInputStream fis = new FileInputStream(file)) {
//                prop.load(fis);
//            }
//        }
//        return prop;
//    }
//
//    /**
//     * Builds a JSON array of file categories and their translations.
//     * @param List of file category values.
//     * @param Map for language codes to their respective properties objects.
//     * @return Required json array
//     */
//    private JsonArray buildFileCategoriesArray(List<String> categoryValues, Map<String, Properties> languageMap) {
//        JsonArrayBuilder fileCategoriesArrayBuilder = Json.createArrayBuilder();
//
//        for (String category : categoryValues) {
//            JsonObjectBuilder objBuilder = Json.createObjectBuilder();
//            objBuilder.add("name", category.trim());
//
//            JsonArray translationsArray = buildTranslationsArray(category, languageMap);
//            objBuilder.add("translations", translationsArray);
//
//            fileCategoriesArrayBuilder.add(objBuilder);
//        }
//
//        return fileCategoriesArrayBuilder.build();
//    }
//
//    /**
//     * Builds a JSON array of translations for a specific file category.
//     * @param File category for which translations are to be built.
//     * @param Map of language codes to their respective properties objects.
//     * @return JSON array representing the translations for the specified file category.
//     */
//    private JsonArray buildTranslationsArray(String category, Map<String, Properties> languageMap) {
//        JsonArrayBuilder transArrayBuilder = Json.createArrayBuilder();
//        final String prefix = "enoDocumentControl.Range.File_Category.";
//
//        for (Map.Entry<String, Properties> entry : languageMap.entrySet()) {
//            String languageCode = entry.getKey();
//            Properties prop = entry.getValue();
//
//            String key = prefix + category.trim().replace(' ', '_');
//            String translation = prop.getProperty(key);
////	        System.out.println("current language file is " + languageCode);
////	        System.out.println("current translation is " + translation);
//
//            if (translation != null && !translation.isEmpty()) {
//                JsonObjectBuilder transObjBuilder = Json.createObjectBuilder();
//                transObjBuilder.add(languageCode, translation);
//                transArrayBuilder.add(transObjBuilder);
//            }
//        }
//
//        return transArrayBuilder.build();
//    }
//
//    /**
//     * Writes a JSON array to a specified file.
//     * @param JSON array to be written to the file.
//     * @param Path of the file where the JSON array will be written.
//     * @throws IOException if an error occurs while writing to the file.
//     */
//    private void writeJsonToFile(JsonArray fileCategoriesArray, String filePath) throws IOException {
//        JsonObject jsonObj = Json.createObjectBuilder()
//                .add("filecategories", fileCategoriesArray)
//                .build();
//
//        Map<String, Object> properties = new HashMap<>(1);
//        properties.put(JsonGenerator.PRETTY_PRINTING, true);
//
//        JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
//
//        try (FileWriter fileWriter = new FileWriter(filePath);
//             JsonWriter jsonWriter = writerFactory.createWriter(fileWriter)) {
//            jsonWriter.writeObject(jsonObj);
//        }
//    }
//
//
//}
