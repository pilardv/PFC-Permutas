function initMap() {
    var geocoder = new google.maps.Geocoder();
    var latlng = new google.maps.LatLng(37.3580015, -5.9873419);
    var mapOptions = {
      zoom: 8,
      center: latlng
    }
    var map = new google.maps.Map(document.getElementById("map"), mapOptions);
    
    var direccionPlazaActual = document.getElementById("direccionPlazaActual").value;
    geocoder.geocode( { 'address': direccionPlazaActual}, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
        map.setCenter(results[0].geometry.location);
        var marker = new google.maps.Marker({
            map: map,
            position: results[0].geometry.location
        });
      } else {
        alert("Geocode was not successful for the following reason: " + status);
	      }
	  });
}
google.maps.event.addDomListener(window, 'load', initMap);