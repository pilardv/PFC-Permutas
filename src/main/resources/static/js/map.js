function initMap() {
    var geocoder = new google.maps.Geocoder();
    
    // Posicion de Sevilla
    var latlng = new google.maps.LatLng(37.3580015, -5.9873419);
    
    var mapOptions = {
      zoom: 8,
      center: latlng
    }
    
    var map = new google.maps.Map(document.getElementById("map"), mapOptions);
    
    var direccionPlazaActual = document.getElementById("direccionPlazaActual").value;
    var numPlazasDeseadas = document.getElementById("segmentoSel").childElementCount;
    
    if(null != direccionPlazaActual){
    	geocoder.geocode( { 'address': direccionPlazaActual}, function(results, status) {
    	      if (status == google.maps.GeocoderStatus.OK) {
    	        map.setCenter(results[0].geometry.location);
    	        
    	        var miPlaza = new google.maps.Marker({
    	            map: map,
    	            position: results[0].geometry.location,
    	            title: 'Mi plaza',
    	            animation: google.maps.Animation.DROP
    	        });
    	        
    	        miPlaza.setMap(map);
    	        
    	      } else {
    	        alert("Geocode was not successful for the following reason: " + status);
    		      }
    		  });
    }
    
    if(numPlazasDeseadas > 1){    	
    	
    	for(i=1; i < document.getElementById("segmentoSel").childElementCount ; i++){
    		
    		var direccionPlazaDeseada =  document.getElementById("segmentoSel")[i].innerText;
    		
    		geocoder.geocode( { 'address': direccionPlazaDeseada}, function(results, status) {
      	      if (status == google.maps.GeocoderStatus.OK) {
      	        map.setCenter(results[0].geometry.location);
      	        
      	        var plazaDeseada = new google.maps.Marker({
//      	        	icon: {
//      	        	  fillColor: '#00f'
//      	        	},
      	            position: results[0].geometry.location,
      	            title: 'Plaza deseada',
      	            map: map
      	        });
      	        
      	        plazaDeseada.setMap(map);
      	        
      	      } else {
      	        alert("Geocode was not successful for the following reason: " + status);
      		      }
      		  });
    	}
    	
    }
    
}
//google.maps.event.addDomListener(window, 'load', initMap);