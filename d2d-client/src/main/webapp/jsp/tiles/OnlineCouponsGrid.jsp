<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script>
$(document).ready(function(){        
	var onlineOffers = '{"dotdList":[{"title":"Just At Rs 199","description":"Hair Dryer","url":"http://dl.flipkart.com/dl/nova-silky-shine-1200-w-hot-cold-foldable-nhp-8100-hair-dryer/p/itme7xh6qujresvz?pid=HDRE7XH6KNNVWYVP&offer=s:wsb4fr1q8ifc2po7:c:076bd4ba04.&affid=gurupritm","availability":"In-stock"},{"title":"Just at Rs. 415","description":"","url":"http://dl.flipkart.com/dl/sandisk-sdhc-16-gb-48-mb-s-class-10-ultra/p/itmdgf8fbv6jjgpg?pid=ACCD6KQ3PRMMPJPT&offer=DOTDOnMemorycard_Aug6.&affid=gurupritm","availability":"In-stock"},{"title":"Flat 50% off","description":"Shirts, trousers and more","url":"http://dl.flipkart.com/dl/promotion/pr?offer=DOTDOnLifestyle_Aug6.&sid=2oq,s9b&affid=gurupritm","availability":"In-stock"},{"title":"Just at Rs. 167","description":"","url":"http://dl.flipkart.com/dl/sandisk-microsd-card-8-gb-class-4/p/itmeyfrqxfftnhcs?pid=ACCCRRQZ2BHPWWEH&offer=DOTDOnMemorycard_1_Aug6.&affid=gurupritm","availability":"In-stock"},{"title":"Flat 20% Off","description":"Make up","url":"http://dl.flipkart.com/dl/promotion/pr?offer=DOTDOnLifestyle_1_Aug6.&sid=t06,fy9&affid=gurupritm","availability":"In-stock"},{"title":"At Flat 299","description":"Bangles, Earrings and more","url":"http://dl.flipkart.com/dl/promotion/pr?offer=s:b69ewai17ajt8clp:c:075a18fe04.&sid=mcr&affid=gurupritm","availability":"In-stock"},{"title":"Flat 60% off","description":"Sports Footwear for Men","url":"http://dl.flipkart.com/dl/promotion/pr?offer=DOTDOnSports_Aug6.&sid=osp,cil&affid=gurupritm","availability":"In-stock"},{"title":"Below Rs. 399","description":"Topsheets","url":"http://dl.flipkart.com/dl/promotion/pr?offer=s:s4973jsvvlpodono:c:073862f204.&sid=vdm&affid=gurupritm","availability":"In-stock"},{"title":"Below Rs. 750","description":"Micromax Joy","url":"http://dl.flipkart.com/dl/promotion/pr?offer=s:xqbcr9dvmngtc7vn:c:077dc3be04.&sid=tyy,4io&affid=gurupritm","availability":"In-stock"},{"title":"Minimum 25% OFF","description":"On Best Selling Games","url":"http://dl.flipkart.com/dl/promotion/pr?offer=DOTDOnCE_Aug6.&sid=4rr&affid=gurupritm","availability":"In-stock"},{"title":"Minimum 35% off","description":"Best Selling Titles","url":"http://dl.flipkart.com/dl/promotion/pr?offer=s:132ad84b571a4fd5:c:075b36c904.&sid=bks&affid=gurupritm","availability":"In-stock"},{"title":"Today At Rs 249","description":"Wireless Mouse","url":"http://dl.flipkart.com/dl/speed-wireless-optical-mouse/p/itmeyrjnff5mkwpe?pid=ACCEYRJNBHB8WK2Z&offer=s:8v71v8oph3ra0kw7:c:072434e104.&affid=gurupritm","availability":"In-stock"}]}';

var onlineData = $.parseJSON(onlineOffers );
var noOfOffers = 1;
$.each(onlineData.dotdList, function( index, value ) {
 if(value.description != null && value.description != "" && noOfOffers <= 7){
  if(noOfOffers <= 7){
  var column = '<div class="col-md-3" style="padding:5px;">';
  column += '<div style="margin:2%;padding:2%;background:#fff;min-height:200px;">';
  column += '<img class="img-responsive" style="width:100%;" src="http://helpbharat.com/images/new-site/flipkart.com_logo.png" alt="'+value.description+'"/>';
  column += '<div style="font-size: 14px; text-transform: uppercase; color: #333; font-weight: bold; width: 100%;padding:5px;">'+value.description + ' @ ' + value.title + '</div>';
  column += '<div class="btn btn-primary" style=" width: 100%;" onclick="window.open(' + "'" + value.url + "'" + ')">VIEW DEAL</div><div class="clear"></div>';				
  column += '</div></div>';
  $('#online-offers-div').append(column);
}
  noOfOffers++;
 }
});
if(noOfOffers > 7){
    var column=' <div style="padding:5px;" class="col-md-3"><a style="color: rgb(255, 255, 255); font-size: 20px; float: none; padding: 0%; margin: auto;" href="#" class="text-center"><div style="background: rgb(231, 111, 98) none repeat scroll 0% 0%; min-height: 200px; float: none; text-align: center; margin: 2%; padding: 20%;">VIEW ALL 3'+ noOfOffers +' <br>ONLINE DEALS</div></a></div>';
$('#online-offers-div').append(column);
}
});
</script>

<div id="online-offers-div">

   
</div>       
