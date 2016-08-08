public class Customer {
    private int id;
    private String gender;
    private String first_name;
    private String email;
    private boolean opt_in;
    private String register_date;
    private String last_review;
    private boolean deactivated;
    private String deactivate_date;
    private String session;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmaill() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isOpt_in() {
        return opt_in;
    }

    public void setOpt_in(boolean opt_in) {
        this.opt_in = opt_in;
    }

    public String getRegister_date() {
        return register_date;
    }

    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }

    public String getLast_review() {
        return last_review;
    }

    public void setLast_review(String last_review) {
        this.last_review = last_review;
    }

    public boolean isDeactivated() {
        return deactivated;
    }

    public void setDeactivated(boolean deactivated) {
        this.deactivated = deactivated;
    }

    public String getDeactivate_date() {
        return deactivate_date;
    }

    public void setDeactivate_date(String deactivate_date) {
        this.deactivate_date = deactivate_date;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

}
