<div class="container mt-4 mb-4 pt-4" style="min-height: 800px;">
  <div class="row justify-content-center pt-4">
    <div class="card" style="max-width: 600px; height: 250px;">
      <div class="row g-0 mb-2">
        <div class="card-body">
          <p class="card-text pt-2 pb-2">
          <h2>${message}</h2>
          <div id='message'></div>
          </p>
        </div>
      </div>
    </div>
  </div>
</div>

<script language="javascript">
  var num = 4;
  var URL = '${url}';
  window.setTimeout("doUpdate()", 1000);
  function doUpdate()
  {
    if(num != 0)
    {
      document.getElementById('message').innerHTML = '<h2>Jump after '+num+' seconds</h2>';
      num --;
      window.setTimeout("doUpdate()", 1000);
    }
    else
    {
      num = 4;
      window.location = URL;
    }
  }
</script>

