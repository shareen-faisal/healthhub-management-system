class NodeA {

    Appointment data;
    NodeA prev;
    NodeA next;

    public NodeA(Appointment data) {
  	  this.data = data;
      this.prev = null;
      this.next = null;
    }//constructor

    public Appointment getdata(){
      return data;
    }

    public NodeA getnext(){
      return next;
    }

       public void setnext(NodeA n){
          next=n;
      }


 }//class