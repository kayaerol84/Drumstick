<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="A layout example that shows off a responsive email layout.">

    <title>Drumstick | Main</title>

    


<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">





  
    <!--[if lte IE 8]>
        <link rel="stylesheet" href="/combo/1.17.16?/css/layouts/email-old-ie.css">
    <![endif]-->
    <!--[if gt IE 8]><!-->
        <link rel="stylesheet" href="static/css/email.css">
    <!--<![endif]-->
  




    
<!--[if lt IE 9]>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7/html5shiv.js"></script>
<![endif]-->


    

    
<script>
(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
})(window,document,'script','//www.google-analytics.com/analytics.js','ga');

ga('create', 'UA-41480445-1', 'purecss.io');
ga('send', 'pageview');
</script>

<script type="text/javascript" src="static/js/script1.js"></script>

</head>
<body>






<div id="layout" class="content pure-g">
    <div id="nav" class="pure-u">
        <a href="#" class="nav-menu-button">Menu</a>

        <div class="nav-inner">
            <a class="pure-menu-heading" href="">DRUMSTICK</a>

            <div class="pure-menu pure-menu-open">
                <ul>
                	<br>
                	<br>
                    <li><a href="http://localhost:8080/drumstick/loadPersonalFinal" id="a1"><span class="email-label-personal"></span>Personal&nbsp;<span class="email-count">(2)</span></a></li>
                    <li><a href="http://localhost:8080/drumstick/loadFamilyFinal" id="a2"><span class="email-label-work"></span>Family&nbsp;<span class="email-count">(8)</span></a></li>
                    <li><a href="http://localhost:8080/drumstick/loadFriendsFinal" id="a3"><span class="email-label-friends"></span>Friends&nbsp;<span class="email-count">(12)</span></a></li>
                    <li><a href="http://localhost:8080/drumstick/loadPublicFinal" id="a4"><span class="email-label-travel"></span><b><font color=#01DF3A size="5">Public</font></b>&nbsp;<span class="email-count">(25)</span></a></li>
                </ul>
            </div>
        </div>
    </div>

    <div id="list" class="pure-u-1">
    
        <div class="email-item email-item-unread pure-g">
        
        	<div class="pure-u-3-4">
	                <h4 class="email-title2">Transactions Notifications </h4>
            	</div>
            	
           
        
            <div class="pure-u">
                <img class="email-avatar2" alt="Tilo Mitra&#x27;s avatar" height="64" width="64" src="static/images/tilo-avatar.png">
               <span class="email-desc"><span class="email-name">RAGHUMAN BABU JAYARAMAN</span> transferred <font color=#01A9DB>10 EUR</font> on <font color="#01A9DB">11/Nov/2014 2.29 AM GMT+1.00</font> to <span class="email-name">RAMYA DHARUMAN</span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <img class="picture-bottom" alt="Tilo Mitra&#x27;s avatar" height="64" width="64" src="static/images/ericf-avatar.png">
                <br><button class="comment-button">comment</button>&nbsp;&nbsp;<button class="comment-button">like</button>&nbsp;&nbsp;<button class="comment-button">pay</button>
        	</div>

            
            
        </div>
        
        
        <#list transactions.list as transaction>
        
        	<div class="email-item email-item-unread pure-g">
        
	        	<div class="pure-u">
	                <img class="email-avatar2" alt="Tilo Mitra&#x27;s avatar" height="64" width="64" src="static/images/tilo-avatar.png">
	               <span class="email-desc"><span class="email-name">${transaction.productId}</span> transferred <font color=#01A9DB>${transaction.amount.value} ${transaction.currency.code}</font> on <font color="#01A9DB">${transaction.effectiveDate.datetime}</font> to <span class="email-name">${transaction.counterpartProductId}</span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
	                <img class="picture-bottom" alt="Tilo Mitra&#x27;s avatar" height="64" width="64" src="static/images/ericf-avatar.png">
	                <br><button class="comment-button">comment</button>&nbsp;&nbsp;<button class="comment-button">like</button>&nbsp;&nbsp;<button class="comment-button">pay</button>
	        	</div>
        	
        	</div>
    
		</#list>

        
    </div>

    <div id="main" class="pure-u-1">
        <div class="email-content">
        
	                
        
        <div class="email-content-body">
        <h4 class="email-title2">PUBLIC</h4>
        <input type="text" size="30" />
        <button class="primary-button pure-button" onclick="callSearchConnectUrl()">Search & Connect</button>
        </div>
            <!-- <div class="email-content-header pure-g">
                <div class="pure-u-1-2">
                    <h2 class="email-content-title">Family</h2>
                </div>
            </div>
            
           <div class="email-content-header pure-g">
                   <button type="button">Connect</button>&nbsp;<input type="text" name="connectaccount"> 
                </div> -->

            <div class="email-content-body">
            
            	<h4 class="email-title2">CONNECTED ACCOUNTS</h4>
            	
            	<div class="pure-u">
	                <img class="email-avatar" alt="Tilo Mitra&#x27;s avatar" height="64" width="64" src="static/images/tilo-avatar.png">
	            </div>
                <div class="pure-u-3-4">
	                <h5 class="email-name2">Erol Mehmed Shaban</h5>
	                <span class="email-subject">NL11INGB0005226379</span>&nbsp;&nbsp;<span class="email-subject">ING Bank Spain</span>
	                
	            </div>
	            
            	<br>
            	<br>
            	
            	<#list connectedAccountList as account>
	            	<div class="pure-u">
		                <img class="email-avatar" alt="Tilo Mitra&#x27;s avatar" height="64" width="64" src="static/images/reid-avatar.png">
		            </div>
		            <div class="pure-u-3-4">
		                <h5 class="email-name2">${account.connectedUserName}</h5>
		                <span class="email-subject">${account.connectedAccountIBAN}</span>&nbsp;&nbsp;<span class="email-subject">${account.connectedAccountsBank}</span>
		            </div>
		            <br>
            		<br>
		         </#list>
	            
	            
            
            </div>
        </div>
    </div>
</div>

<script src="http://yui.yahooapis.com/3.17.2/build/yui/yui-min.js"></script>

<script>
    YUI().use('node-base', 'node-event-delegate', function (Y) {

        var menuButton = Y.one('.nav-menu-button'),
            nav        = Y.one('#nav');

        // Setting the active class name expands the menu vertically on small screens.
        menuButton.on('click', function (e) {
            nav.toggleClass('active');
        });

        // Your application code goes here...

    });
</script>


<script>
(function (root) {
// -- Data --
root.YUI_config = {"version":"3.17.2","base":"http:\u002F\u002Fyui.yahooapis.com\u002F3.17.2\u002F","comboBase":"http:\u002F\u002Fyui.yahooapis.com\u002Fcombo?","comboSep":"&","root":"3.17.2\u002F","filter":"min","logLevel":"error","combine":true,"patches":[],"maxURLLength":2048,"groups":{"vendor":{"combine":true,"comboBase":"\u002Fcombo\u002F1.17.16?","base":"\u002F","root":"\u002F","modules":{"css-mediaquery":{"path":"vendor\u002Fcss-mediaquery.js"},"handlebars-runtime":{"path":"vendor\u002Fhandlebars.runtime.js"}}},"app":{"combine":true,"comboBase":"\u002Fcombo\u002F1.17.16?","base":"\u002Fjs\u002F","root":"\u002Fjs\u002F"}}};
root.app || (root.app = {});
root.app.yui = {"use":function () { return this._bootstrap('use', [].slice.call(arguments)); },"require":function () { this._bootstrap('require', [].slice.call(arguments)); },"ready":function (callback) { this.use(function () { callback(); }); },"_bootstrap":function bootstrap(method, args) { var self = this, d = document, head = d.getElementsByTagName('head')[0], ie = /MSIE/.test(navigator.userAgent), callback = [], config = typeof YUI_config != "undefined" ? YUI_config : {}; function flush() { var l = callback.length, i; if (!self.YUI && typeof YUI == "undefined") { throw new Error("YUI was not injected correctly!"); } self.YUI = self.YUI || YUI; for (i = 0; i < l; i++) { callback.shift()(); } } function decrementRequestPending() { self._pending--; if (self._pending <= 0) { setTimeout(flush, 0); } else { load(); } } function createScriptNode(src) { var node = d.createElement('script'); if (node.async) { node.async = false; } if (ie) { node.onreadystatechange = function () { if (/loaded|complete/.test(this.readyState)) { this.onreadystatechange = null; decrementRequestPending(); } }; } else { node.onload = node.onerror = decrementRequestPending; } node.setAttribute('src', src); return node; } function load() { if (!config.seed) { throw new Error('YUI_config.seed array is required.'); } var seed = config.seed, l = seed.length, i, node; if (!self._injected) { self._injected = true; self._pending = seed.length; } for (i = 0; i < l; i++) { node = createScriptNode(seed.shift()); head.appendChild(node); if (node.async !== false) { break; } } } callback.push(function () { var i; if (!self._Y) { self.YUI.Env.core.push.apply(self.YUI.Env.core, config.extendedCore || []); self._Y = self.YUI(); self.use = self._Y.use; if (config.patches && config.patches.length) { for (i = 0; i < config.patches.length; i += 1) { config.patches[i](self._Y, self._Y.Env._loader); } } } self._Y[method].apply(self._Y, args); }); self.YUI = self.YUI || (typeof YUI != "undefined" ? YUI : null); if (!self.YUI && !self._injected) { load(); } else if (self._pending <= 0) { setTimeout(flush, 0); } return this; }};
root.YUI_config || (root.YUI_config = {});
root.YUI_config.seed = ["http:\u002F\u002Fyui.yahooapis.com\u002Fcombo?3.17.2\u002Fyui\u002Fyui-min.js"];
root.YUI_config.groups || (root.YUI_config.groups = {});
root.YUI_config.groups.app || (root.YUI_config.groups.app = {});
root.YUI_config.groups.app.modules = {"start\u002Fapp":{"path":"start\u002Fapp.js","requires":["handlebars-runtime","yui","base-build","router","pjax-base","view","start\u002Fmodels\u002Fgrid","start\u002Fviews\u002Finput","start\u002Fviews\u002Foutput","start\u002Fviews\u002Fdownload"]},"start\u002Fmodels\u002Fgrid":{"path":"start\u002Fmodels\u002Fgrid.js","requires":["yui","querystring","base-build","model","model-sync-rest","start\u002Fmodels\u002Fmq"]},"start\u002Fmodels\u002Fmq":{"path":"start\u002Fmodels\u002Fmq.js","requires":["css-mediaquery","attribute","base-build","model","model-list"]},"start\u002Fviews\u002Fdownload":{"path":"start\u002Fviews\u002Fdownload.js","requires":["yui","base-build","querystring","view"]},"start\u002Fviews\u002Finput":{"path":"start\u002Fviews\u002Finput.js","requires":["base-build","start\u002Fmodels\u002Fmq","start\u002Fviews\u002Ftab"]},"start\u002Fviews\u002Foutput":{"path":"start\u002Fviews\u002Foutput.js","requires":["base-build","escape","start\u002Fviews\u002Ftab"]},"start\u002Fviews\u002Ftab":{"path":"start\u002Fviews\u002Ftab.js","requires":["yui","base-build","view"]}};
}(this));
</script>
<script>
app.yui.use('node-base', 'node-event-delegate', function (Y) {
    // This just makes sure that the href="#" attached to the <a> elements
    // don't scroll you back up the page.
    Y.one('body').delegate('click', function (e) {
        e.preventDefault();
    }, 'a[href="#"]');
});
</script>






</body>
</html>
