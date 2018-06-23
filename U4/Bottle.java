class Bottle<T extends Drink> {
      private T content;
      
      public boolean isEmpty () {
        return this.content == null;
      }

      public void fill (T content) {
        if (this.content != null)
          throw new IllegalStateException ();
        this.content = content;
      }
      public T empty () {
        if (this.content == null)
          throw new IllegalStateException ();
        T content = this.content;
        this.content = null;
        return content;
      }
    }
