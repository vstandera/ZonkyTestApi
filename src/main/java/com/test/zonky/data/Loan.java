package com.test.zonky.data;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Generated object Loan form JSON.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Loan {

    private Long id;
    private String url;
    private String name;
    private String story;
    private String purpose;
    private List<Photo> photos = null;
    private String nickName;
    private Integer termInMonths;
    private Double interestRate;
    private String rating;
    private Boolean topped;
    private Integer amount;
    private Integer remainingInvestment;
    private Double investmentRate;
    private Boolean covered;
    private String datePublished;
    private Boolean published;
    private Date deadline;
    private Integer investmentsCount;
    private Integer questionsCount;
    private String region;
    private String mainIncomeType;
    private Boolean insuranceActive;
    private List<InsuranceHistory> insuranceHistory = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getTermInMonths() {
        return termInMonths;
    }

    public void setTermInMonths(Integer termInMonths) {
        this.termInMonths = termInMonths;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Boolean getTopped() {
        return topped;
    }

    public void setTopped(Boolean topped) {
        this.topped = topped;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getRemainingInvestment() {
        return remainingInvestment;
    }

    public void setRemainingInvestment(Integer remainingInvestment) {
        this.remainingInvestment = remainingInvestment;
    }

    public Double getInvestmentRate() {
        return investmentRate;
    }

    public void setInvestmentRate(Double investmentRate) {
        this.investmentRate = investmentRate;
    }

    public Boolean getCovered() {
        return covered;
    }

    public void setCovered(Boolean covered) {
        this.covered = covered;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getInvestmentsCount() {
        return investmentsCount;
    }

    public void setInvestmentsCount(Integer investmentsCount) {
        this.investmentsCount = investmentsCount;
    }

    public Integer getQuestionsCount() {
        return questionsCount;
    }

    public void setQuestionsCount(Integer questionsCount) {
        this.questionsCount = questionsCount;
    }

    public String getRegion() {
        return region;
    }

    public String getMainIncomeType() {
        return mainIncomeType;
    }

    public void setMainIncomeType(String mainIncomeType) {
        this.mainIncomeType = mainIncomeType;
    }

    public Boolean getInsuranceActive() {
        return insuranceActive;
    }

    public void setInsuranceActive(Boolean insuranceActive) {
        this.insuranceActive = insuranceActive;
    }

    public List<InsuranceHistory> getInsuranceHistory() {
        return insuranceHistory;
    }

    public void setInsuranceHistory(List<InsuranceHistory> insuranceHistory) {
        this.insuranceHistory = insuranceHistory;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", story='" + story + '\'' +
                ", purpose='" + purpose + '\'' +
                ", photos=" + photos +
                ", nickName='" + nickName + '\'' +
                ", termInMonths=" + termInMonths +
                ", interestRate=" + interestRate +
                ", rating='" + rating + '\'' +
                ", topped=" + topped +
                ", amount=" + amount +
                ", remainingInvestment=" + remainingInvestment +
                ", investmentRate=" + investmentRate +
                ", covered=" + covered +
                ", datePublished='" + datePublished + '\'' +
                ", published=" + published +
                ", deadline='" + deadline + '\'' +
                ", investmentsCount=" + investmentsCount +
                ", questionsCount=" + questionsCount +
                ", region='" + region + '\'' +
                ", mainIncomeType='" + mainIncomeType + '\'' +
                ", insuranceActive=" + insuranceActive +
                ", insuranceHistory=" + insuranceHistory +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
