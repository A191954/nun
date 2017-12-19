$("ul.side-nav > li > a").click(function(){
			$("ul.side-nav ul").slideUp("slow")
			if(!$(this).next().is(":visible"))
				{
					$(this).next().slideDown("slow");
				}
		});
		
		$(".top-nav a").click(function(){
			$(this).next().toggle();
		});
