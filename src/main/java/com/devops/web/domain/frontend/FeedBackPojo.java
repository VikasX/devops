package com.devops.web.domain.frontend;

import java.io.Serializable;

/**
 * Created by XxX on 7/19/2017.
 */
public class FeedBackPojo implements Serializable{

    private static final long serialVersionUID = 1L;

    private String email;
    private String firstN;
    private String lastN;

    private String feedback;


    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstN(String firstN) {
        this.firstN = firstN;
    }

    public void setLastN(String lastN) {
        this.lastN = lastN;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstN() {
        return firstN;
    }

    public String getLastN() {
        return lastN;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FeedBackPojo{");
        sb.append("email='").append(email).append('\'');
        sb.append(", firstN='").append(firstN).append('\'');
        sb.append(", lastN='").append(lastN).append('\'');
        sb.append(", feedback='").append(feedback).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
