<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<script>
    var url = '${context}/offer/getOfferForCloud.htm?cname=';
	var basic_words = [
	{text: "coupons", weight: 13, link: url+'coupons'},
	{text: "offers", weight: 11.5, link: url+'offers'},
	{text: "deals", weight: 10, link: url+'deals'},
	{text: "coupon codes", weight: 8, link: url+'coupon'},
	{text: "promo codes", weight: 6.2, link: url+'promo'},
	{text: "online offers", weight: 5, link: url+'offline'},
	{text: "offline offers", weight: 5, link: url+'offline'},
	{text: "walkin deals", weight: 5, link: url+'walkin'},
	{text: "corporate offers", weight: 5, link: url+'corporate'},
	{text: "group discount", weight: 4, link: url+'group'},
	{text: "pune deals", weight: 4, link: url+'pune deal'},
	{text: "mumbai offers", weight: 3, link: url+'mumbai'},
	{text: "flipkart", weight: 3, link: url+'flipkart'},
	{text: "firstcry", weight: 3, link: url+'first cry'},
	{text: "amazon", weight: 3, link: url+'amazon'},	
	{text: "paytm", weight: 2, link: url+'paytm'},
	{text: "foodpanda", weight: 2, link: url+'foodpanda'},
	{text: "shopclues", weight: 2, link: url+'shopclues'},
	{text: "ebay", weight: 2, link: url+'eaby'},
	{text: "fast food", weight: 2, link: url+'fast food'},	
	{text: "restorents", weight: 2, link: url+'restorent'},
	{text: "spa and salon", weight: 2, link: url+'spa salon'},
	{text: "restorent deals", weight: 1, link: url+'restorent deals'},	
	{text: "coupons", weight: 1, link: url+'coupons'},
	{text: "coupon codes", weight: 1, link: url+'coupon codes'},	
	{text: "promotions", weight: 1, link: url+'promotions'},
	{text: "promo codes", weight: 1, link: url+'promo codes'},
	{text: "city deals", weight: 1, link: url+'city deals'}
	];

	var linked_words = $.extend(true, [], basic_words);
	linked_words.splice(0, 3, 
		{text: "coupons", weight: 13, link: url+'coupon'},
		{text: "offers", weight: 10.5, link: url+'offer'},
		{text: "deals", weight: 9.4, link: url+'deals'}
	);

	$('#demo-link').jQCloud(linked_words);
</script>