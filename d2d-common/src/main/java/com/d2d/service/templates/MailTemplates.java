package com.d2d.service.templates;


public class MailTemplates {
    public static String getMerchantSignUpMailTemplate(String providerName, String mailId, String verificationCode) {
        return "Hello " + providerName + "," + "\r\n\r\nFirst of all, Hearty wishes on signing up with deal2day.in" + "\r\n\r\nWe are excited to have you on-board and can't wait to see your business achieve greater heights." + "\r\n\r\nSpeaking of business, we convert every second of your interaction with us productive." + "\r\n\r\nPlease click on the following link to confirm your MERCHANT SIGNUP on deal2day.in :" + "\r\nhttp://deal2day.in/provider/verify.htm?mailId=" + mailId + "&code=" + verificationCode + "\r\n\r\nWe are just one mail away to you. Write to us at contact@deal2day.in" + " and we will reply back to you with the solution to any of your needs." + "\r\n\r\nHappy to see your business GROW." + "\r\n\r\nBest Regards," + "\r\nTeam Deal2Day.in";
    }

    public static String getInviteFriendMailTemplate(String friendName, String emailIds) {
        return "Hi " + friendName + "," + "\r\n\r\nTry out FREE COUPONS on various retail outlets only at deal2day.in" + "\r\n\r\nIt offers great value deals on all kinds of products with fabulous discounts." + "\r\n\r\nYou will get a wide range of  FOOD, SPA services, HOTELS, APPAREL " + "and many more luxuries at GREAT DISCOUNTS only on Deal2Day.in" + "\r\n\r\nTry now and showoff the best prices you can get." + "\r\n\r\nBest Regards," + "\r\n" + emailIds;
    }

    public static String getMerchantOfferConfirmationMailTemplate(String providerName, String offerName, String offerStatus, String startDate, String endDate) {
        return "Hello " + providerName + "," + "\r\n\r\nYour " + offerName + " has been confirmed and is currently " + offerStatus.toUpperCase() + "\r\n\r\nCampaign starting date: " + startDate + "\r\nCampaign ending date: " + endDate + "\r\n\r\nPlease check the portal in case of any modifications." + "\r\n\r\nHappy to see your business GROW." + "\r\n\r\nBest Regards," + "\r\nTeam Deal2Day.in";
    }

    public static String getContactUsMailTemplate(String fullName) {
        return "Hi " + fullName + "," + "\r\n\r\nTeam Deal2day.in has received your query and we will get back to you with the required support" + " to help you enjoy a hassle-free service." + "\r\n\r\nThank you for your patience." + "\r\n\r\nStriving to get BEST DEALS for you 24/7" + "\r\n\r\nBest Regards," + "\r\nTeam Deal2Day.in";
    }

    public static String getAdvertiseWithUsMailTemplate(String companyName) {
        return "Hi " + companyName + "," + "\r\n\r\nThank you for writing to us. We took note of your deal specifications. Now, we will search for the " + "best fit deals for you in your area of preference and get back at the earliest." + "\r\n\r\nThanks for choosing Deal2Day.in as your deal partner." + "\r\n\r\nStriving to get BEST DEALS for you 24/7" + "\r\n\r\nBest Regards," + "\r\nTeam Deal2Day.in";
    }

    public static String getMyDealMailTemplate(String fullName) {
        return "Hi " + fullName + "," + "\r\n\r\nThank you for writing to us. We took note of your deal specifications. Now, we will search for the " + "best fit deals for you in your area of preference and get back at the earliest." + "\r\n\r\nThanks for choosing Deal2Day.in as your deal partner." + "\r\n\r\nStriving to get BEST DEALS for you 24/7" + "\r\n\r\nBest Regards," + "\r\nTeam Deal2Day.in";
    }
    
    public static String getSubscriberConfirmationMailTemplate(String activateURL){
    	return "Hi," + "\r\n\r\nThank you for subscribing to Deal2day Newsletter.. Before we start your email subscription you must confirm your subscription by clicking the following link:"+ activateURL +". "+ "\r\n\r\nBest Regards," + "\r\nTeam Deal2Day.in";
    }
    
    public static String getUnsubscriberConfirmationMailTemplate(){
    	return "Hi," + "\r\n\r\n You have successfully cancelled your subscription with Deal2Day. Although it brings a cloud of sadness in our minds to see you leave, we understand that there might be good reasons as to why you have decided to leave the family."+
                "\n"+"We would like to receive your feedback and learn your comments about your experience with us and where you would like us to improve."+"\n"+"We hope to better the user experience and welcome you back to our site soon."+
    			"\r\n\r\nThanks and Regards," + "\r\nThe Deal2Day Team";

    }

    public static void main(String[] args) {
        System.out.println(MailTemplates.getMyDealMailTemplate("EVORLD"));
    }
}

