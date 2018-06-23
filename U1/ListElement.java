public class ListElement{
    private String content;
    private ListElement next; 
    public ListElement(String content){
        //Objects.requireNonNull(content);
        if (content.isEmpty()) {
        throw new IllegalArgumentException("The argument 'content' cannot be empty!");
        }
        this.content=content;
    }
    public void setContent(String content){
        //Objects.requireNonNull(content);
        if (content.isEmpty()) {
        throw new IllegalArgumentException("The argument 'content' cannot be empty!");
        }
        this.content=content;
    }
    public String getContent(){
        return content;
    }
    public void setNext(ListElement next){
        this.next=next;
    }
    public ListElement getNext(){
        return next;
    }
    
}