Comment comment = new Comment(timestamp,author,content)

class Comment{

  String author;
  Long timestamp;
  String content;

  public Comment(Long timestamp, String author, String content){
    this.author = author;
    this.timestamp = timestamp;
    this.content = content;

  }
  @Override
  toString(){
    return
  }

}


  main(){


    String toProcess = "191238914721,dtrump,hey yall nkorea gota bomb"
    String[] processed = toProcess.split(",")
    Comment comment = new Comment(Long.valueof(toProcess[0]),toProcess[1],toProcess[2]);
