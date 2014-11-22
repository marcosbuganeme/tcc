var configurarMoeda = function() {
	$('.moeda:not(.moeda-masked)').maskMoney({
		decimal : ',',
		thousands : '.',
		allowZero : true
	});
	$('.moeda:not(.moeda-masked)').addClass('moeda-masked');
};