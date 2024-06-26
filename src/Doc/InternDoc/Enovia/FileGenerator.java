package Doc.InternDoc.Enovia;

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    public static void main(String[] args) {
        try {
            // generate enoDocumentControl.properties
            FileWriter writer = new FileWriter("enoDocumentControl.properties");
            writer.write("enoDocumentControl.FileCategory.RangeValues=Skip PDF,Attachment,Digital Signature,Wet Signature,Heterogeneous,Internal Project Document,External Project Document,Internal Technical Document,External Technical Document,Appendix");
            writer.close();

            // generate enoDocumentControlStringResource_en.properties
            writer = new FileWriter("enoDocumentControlStringResource_en.properties");
//            writer.write("enoDocumentControl.Range.File_Category.Appendix=Appendix\n");
            writer.write("enoDocumentControl.Range.File_Category.Internal_Technical_Document=Internal Technical Document\n");
            writer.write("enoDocumentControl.Range.File_Category.External_Technical_Document=External Technical Document\n");
            writer.write("enoDocumentControl.Range.File_Category.Internal_Project_Document=Internal Project Document\n");
            writer.write("enoDocumentControl.Range.File_Category.External_Project_Document=External Project Document\n");
            writer.write("enoDocumentControl.Range.File_Category.Digital_Signature=Digital Signature\n");
            writer.write("enoDocumentControl.Range.File_Category.Skip_PDF=Skip PDF\n");
            writer.write("enoDocumentControl.Range.File_Category.Attachment=Attachment\n");
            writer.write("enoDocumentControl.Range.File_Category.Wet_Signature=Wet Signature\n");
            writer.write("enoDocumentControl.Range.File_Category.Heterogeneous=Heterogeneous");
            writer.close();

            // generate enoDocumentControlStringResource_fr.properties
            // randomly translate
            writer = new FileWriter("enoDocumentControlStringResource_fr.properties");
//            writer.write("enoDocumentControl.Range.File_Category.Appendix=Annexe\n");
            writer.write("enoDocumentControl.Range.File_Category.Internal_Technical_Document=Document technique interne\n");
            writer.write("enoDocumentControl.Range.File_Category.External_Technical_Document=Document technique externe\n");
            writer.write("enoDocumentControl.Range.File_Category.Internal_Project_Document=Document de projet interne\n");
            writer.write("enoDocumentControl.Range.File_Category.External_Project_Document=Document de projet externe\n");
            writer.write("enoDocumentControl.Range.File_Category.Digital_Signature=Signature numérique\n");
            writer.write("enoDocumentControl.Range.File_Category.Skip_PDF=Sauter le PDF\n");
            writer.write("enoDocumentControl.Range.File_Category.Attachment=Pièce jointe\n");
            writer.write("enoDocumentControl.Range.File_Category.Wet_Signature=Signature humide\n");
            writer.write("enoDocumentControl.Range.File_Category.Heterogeneous=Hétérogène");
            writer.close();

            System.out.println("generate successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}