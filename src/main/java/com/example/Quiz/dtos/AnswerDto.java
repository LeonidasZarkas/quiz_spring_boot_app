package com.example.Quiz.dtos;

import com.example.Quiz.models.Answer;

public class AnswerDto {

    private Integer id;
    private String answer;
    private Boolean isright;
    private Integer qid;

    public AnswerDto(Answer a) {
        this.id = a.getAnswerid();
        this.answer = a.getAnswer();
        this.isright = a.getIsright();
        this.qid = a.getQid().getQid();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getIsright() {
        return isright;
    }

    public void setIsright(Boolean isright) {
        this.isright = isright;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(id);
        sb.append(", answer=").append(answer);
        sb.append(", isright=").append(isright);
        sb.append(", qid=").append(qid);
        return sb.toString();
    }
    
    

}
