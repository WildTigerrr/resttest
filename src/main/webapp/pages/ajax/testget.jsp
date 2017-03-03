<html>

    <head>
        <script src="http://code.jquery.com/jquery-1.10.2.min.js" type="text/javascript" ></script>
        <script type="text/javascript">
        $(function() {
            $('button').click(function() {
                var s = document.getElementById("test").value;
                doGet(s);
            });
        });
        doGet = function(s) {
            $("#result").load("/ajax/getinputtest", { string: s });
        }

        </script>
    </head>

    <body>

        <input type="text" value="" id="test">
        <button>Submit</button>
        <div id="result">Waiting...
        </div>

    </body>

</html>