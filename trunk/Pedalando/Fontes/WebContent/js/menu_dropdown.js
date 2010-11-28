/**
 * Menu Principal
 */

$(document).ready(function() {
	$('li.cabeca_menu ul').css('display', 'none');
	$('li.cabeca_menu').hover(function() {
		$('ul',this).addClass("hover");
		$('ul', this).css('display', 'block');
	}, function() {
		$('ul',this).removeClass("hover");
		$('ul', this).css('display', 'none');
	});

	$('#erros').dialog({
		title : "ERROS",
		drabbable : true,
		resizable : true,
		buttons : {
			"OK" : function() {
				$(this).dialog('close');
			}
		}
	});
});