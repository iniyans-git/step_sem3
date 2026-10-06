public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        if (filename == null) {
            return "Rejected — invalid file type";
        }

        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String ext = filename.substring(dotIndex + 1);

        if (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {
        String file1 = "Assignment1.PDF";
        String file2 = "notes.txt";
        String file3 = "project.zip";

        System.out.printf("\"%s\" -> %s%n", file1, validateFileExtension(file1));
        System.out.printf("\"%s\" -> %s%n", file2, validateFileExtension(file2));
        System.out.printf("\"%s\" -> %s%n", file3, validateFileExtension(file3));
    }
}
