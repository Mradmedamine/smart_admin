$.fn.extend({

    jhide : function() {
	return this.addClass('hidden');
    },
    jshow : function() {
	return this.removeClass('hidden');
    },
    jreset : function() {
	this.find('input').val('');
    },
    serializeObject : function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
	    if (o[this.name] !== undefined) {
		if (!o[this.name].push) {
		    o[this.name] = [ o[this.name] ];
		}
		o[this.name].push(this.value || '');
	    } else {
		o[this.name] = this.value || '';
	    }
	});
	return o;
    }
});
