public class List{
    private ListElement listelement;
    public void append(String string){
        ListElement listelement1=listelement;
        if (listelement==null){
            listelement=new ListElement(string);
        }else{
            if (listelement.getNext()==null)
            {
                listelement.setNext(new ListElement(string));
            }else{
                while(listelement.getNext()!=null){
                    listelement=listelement.getNext();
                }
                listelement.setNext(new ListElement(string));
                listelement=listelement1;
            }
        }
    }

    public String remove(String string){
        if (string==null) return null;
        if (string=="") return null;
        if (listelement==null) return null;
        ListElement listelement1=listelement;
        if (listelement.getContent().equals(string)){
                listelement=listelement.getNext();
                return string;
        }
        while(listelement.getNext()!=null){
            if (listelement.getNext().getContent().equals(string)){
                if(listelement.getNext().getNext()==null){
                    listelement.setNext(null);
                }else{
                    listelement.setNext(listelement.getNext().getNext());
                }
                listelement=listelement1;
                return string;
            }
            listelement=listelement.getNext();
        }
        listelement=listelement1;
        return null;
    }
}