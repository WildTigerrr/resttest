 <html>
 <script src="http://code.jquery.com/jquery-1.10.2.min.js" type="text/javascript" ></script>
 <script type="text/javascript">
    function test_load() {
      $("#result").load("/ajax/ajaxtest");
     }
 </script>
 <body>
     <button onclick="test_load();">Load</button>
     <div id="result">Waiting...
     </div>
 </body>
 </html>