
public class Letter {
    private String to;
    private String subject;
    private String body;

    public Letter(String to, String subject, String body) {
        this.body = body;
        this.subject = subject;
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object object){
        if(object == null){
            return false;
        }
        if(!(object instanceof Letter)){
            return false;
        }
        Letter letter = (Letter) object;
        if (!letter.getTo().equals(this.to)){
            return false;
        }
        if (!letter.getSubject().equals(this.subject)){
            return false;
        }
        if (!letter.getBody().equals(this.body)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = getTo() != null ? getTo().hashCode() : 0;
        result = 31 * result + (getSubject() != null ? getSubject().hashCode() : 0);
        result = 31 * result + (getBody() != null ? getBody().hashCode() : 0);
        return result;
    }
}
