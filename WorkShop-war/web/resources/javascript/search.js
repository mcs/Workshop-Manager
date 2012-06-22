// Load category autocomplete plugin
$.widget( "custom.catcomplete", $.ui.autocomplete, {
	_renderMenu: function( ul, items ) {
		var self = this,
		currentCategory = "";
		$.each( items, function( index, item ) {
			if ( item.category != currentCategory ) {
				ul.append( "<li class='ui-autocomplete-category'>" + item.category + "</li>" );
				currentCategory = item.category;
			}
			self._renderItem( ul, item );
		});
	}
}); 

// execute after DOMis loaded
$(function () {
	// attach catcomplete to form element
	$("#searchProduct").catcomplete({
		source: function (request, response) {
			var param = {searchProduct: request.term};
			$.getJSON(ws.contextPath + "/Search.action?ajaxSearch", param, function (data) {
				console.log("data: %o", data);
				response(data);
			});
		},
		select: function (event, ui) {
			console.log("Hello %o", ui.item);
			$.post(ws.contextPath + "/Search.action?ajaxAddProduct", {productId: ui.item.id});
		}
	});
	
});
