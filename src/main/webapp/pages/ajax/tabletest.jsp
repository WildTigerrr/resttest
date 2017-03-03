<html>
    <head>
        <style type="text/css">
            .red {
                background-color: red;
            }
            .green {
                background-color: green;
            }
            .blue {
                background-color: blue;
            }
        </style>
       <script src="http://code.jquery.com/jquery-1.10.2.min.js" type="text/javascript" ></script>
        <script type="text/javascript">

                      $(function() {
                          //назначаем каждой ячейке свой id
                          $('td').each(function(index){
                              $(this).attr('id', index);
                          });

                          //прописываю каждой ячейке листенер
                          $('td').mouseover(function() {
                              $(this).addClass('red');
                          });

                          //$('td').mouseout(function() {
                          //    $(this).addClass('green');
                          //});

                          $('td').click(function() {
                              $(this).removeClass('red').addClass('blue');
                          });

                          //прописываю кнопке листенер, по нажатию осуществляется get-запрос на сервер, и передаются id-шники
                          $('button').click(function() {
                              var r = "";
                              var b = "";

                              $('td').each(function(index){
                                  if ($(this).attr('class') == 'red') {
                                      r += $(this).attr('id') + ', ';
                                  } else if ($(this).attr('class') == 'blue') {
                                    b += $(this).attr('id') + ', ';
                                  }
                              });

                              doGet(r, b);
                          });
                      });
                      // get запроос к серверу. В аргументах - вызываемый сервлет; данные в формате json; функция callback
                      // вы также можете осуществить post или ajax запросы одноименными методами.
                      doGet = function(r, b) {
                          $("#result").load("/ajax/tabletestfin", { red: r, blue: b });
                      }
        </script>
    </head>

    <body>
        <table border="2", cellpadding="15", cellspacing="5">
            <tr>
                <td>0</td>
                <td>1</td>
                <td>2</td>
                <td>3</td>
                <td>4</td>
                <td>5</td>
            </tr>
            <tr>
                <td>6</td>
                <td>7</td>
                <td>8</td>
                <td>9</td>
                <td>10</td>
                <td>11</td>
            </tr>
            <tr>
                <td>12</td>
                <td>13</td>
                <td>14</td>
                <td>15</td>
                <td>16</td>
                <td>17</td>
            </tr>
            <tr>
                <td>18</td>
                <td>19</td>
                <td>20</td>
                <td>21</td>
                <td>22</td>
                <td>23</td>
            </tr>
        </table>
        <button>Submit</button>
        <div id="result">Waiting...
             </div>
    </body>
</html>