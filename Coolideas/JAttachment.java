import java.io.File;

/**
 * JAttachment
 */
public class JAttachment extends JContent{
    private File file;
    public JAttachment(String title,String description,File file){
        super(title, description);
        if (file==null) throw new NullPointerException();
        this.file=file;
    }
    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }
    public void setFile(File file) {
        if (file==null) throw new NullPointerException();
        this.file = file;
    }
    @Override
    public String toString() {
        return "Attachment: "+this.getTitle()+"\n"+this.getDescription();
    }
}