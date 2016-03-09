function initMap() {
  var map = new google.maps.Map(document.getElementById('map'), {
    center: {lat: 0, lng: 0},
    zoom: 3,
    styles: [{
      featureType: 'poi',
      stylers: [{ visibility: 'off' }]  // Turn off points of interest.
    }, {
      featureType: 'transit.station',
      stylers: [{ visibility: 'off' }]  // Turn off bus stations, train stations, etc.
    }],
    disableDoubleClickZoom: true
  });
}  
 
  function initMapWithMarker() {
    var geocoder = new google.maps.Geocoder();
    var latlng = new google.maps.LatLng(37.3580015, -5.9873419);
    var mapOptions = {
      zoom: 8,
      center: latlng
    }
    var map = new google.maps.Map(document.getElementById("map"), mapOptions);
    
    var direccionPlazaActual = document.getElementById("direccionPlazaActual").value;
    geocoder.geocode( { 'direccionPlazaActual': direccionPlazaActual}, function(results, status) {
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