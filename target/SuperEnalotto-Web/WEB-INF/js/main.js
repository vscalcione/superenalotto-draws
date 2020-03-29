$(document).ready(function() {
    $("#valida").click(function() {
        var msg = "";
        var validate = true;
        $(".classe").each(function(b) {
            var element = $("#num" + (b + 1)).val();
            if (element == "") {
                msg = "Inserisci prima i campi";
                validate = false;
            }
        });

        if (validate) {
            $(".classe").each(function(i) {
                var x = $("#num" + (i + 1)).val();
                if ((isNaN(x)) || (x < 1) || (x > 90)) {
                    msg = "Valore inserito non corretto";
                    validate = false;
                } else {
                    $(".classe").each(function(v) {
                        if (v < i) {
                            var y = $("#num" + (v + 1)).val();
                            if (y == x) {
                                msg = "Non inserire numeri doppi! ";
                                validate = false;
                            }
                        }
                    });
                }
            });
        }

        if (validate) {
            var arrayNum = [];
            for (var i = 0; i <= 5; i++) {
                arrayNum[i] = $("#num" + (i + 1)).val();
            }
            $.ajax({
                type : "POST",
                url : "CreateRandom",
                data : {
                    json : JSON.stringify(arrayNum)
                },
                dataType : "json",
                success : function(msg) {
                    $("#risultato").html(msg);
                },
                error : function(aaa) {
                    var test = aaa;
                    alert("Chiamata fallita, si prega di riprovare...");
                }
            });
        } else
            alert(msg);
    });

    $("#rnd").click(function() {
        $.ajax({
            type : "POST",
            url : "CreateRandom",
            dataType : "json",
            success : function(array) {
                for (var c = 0; c <= 5; c++) {
                    $("#num" + (c + 1)).val(array[c]);
                }
            },
            error : function(aaa) {
                var test = aaa;
                alert("Chiamata fallita, si prega di riprovare...");
            }
        });
    });
});

