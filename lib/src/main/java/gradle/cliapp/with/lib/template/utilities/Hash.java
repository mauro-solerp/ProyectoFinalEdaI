package gradle.cliapp.with.lib.template.utilities;

public class Hash {
    /**
     * Hash Code
     * @param data string to hash
     * @return hash code
     */
    public static String hashCode(String data){
        return String.format("%6x", data.hashCode()).trim();
    }
}
