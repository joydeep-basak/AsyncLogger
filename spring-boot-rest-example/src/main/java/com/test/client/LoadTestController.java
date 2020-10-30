package com.test.client;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class LoadTestController {
	
	private static final String DEV_URL = "https://jqvgtqtqu6.execute-api.us-east-1.amazonaws.com/dev/profile/createProfile/true";
	
	private static final String[] vulgarWords = {"hoe","4r5e","50 yard cunt punt","5h1t","5hit","a_s_s","a2m","a55","adult","amateur","anal","anal impaler","anal leakage","anilingus","anus","ar5e","arrse","arse","arsehole","ass","ass fuck","asses","assfucker","ass-fucker","assfukka","asshole","asshole","assholes","assmucus","assmunch","asswhole","autoerotic","b!tch","b00bs","b17ch","b1tch","ballbag","ballsack","bang (one's) box","bangbros","bareback","bastard","beastial","beastiality","beef curtain","bellend","bestial","bestiality","bi+ch","biatch","bimbos","birdlock","bitch","bitch tit","bitcher","bitchers","bitches","bitchin","bitching","bloody","blow job","blow me","blow mud","blowjob","blowjobs","blue waffle","blumpkin","boiolas","bollock","bollok","boner","boob","boobs","booobs","boooobs","booooobs","booooooobs","breasts","buceta","bugger","bum","bunny fucker","bust a load","busty","butt","butt fuck","butthole","buttmuch","buttplug","c0ck","c0cksucker","carpet muncher","carpetmuncher","cawk","chink","choade","chota bags","cipa","cl1t","clit","clit licker","clitoris","clits","clitty litter","clusterfuck","cnut","cock","cock pocket","cock snot","cockface","cockhead","cockmunch","cockmuncher","cocks","cocksuck","cocksucked","cocksucker","cock-sucker","cocksucking","cocksucks","cocksuka","cocksukka","cok","cokmuncher","coksucka","coon","cop some wood","cornhole","corp whore","cox","cum","cum chugger","cum dumpster","cum freak","cum guzzler","cumdump","cummer","cumming","cums","cumshot","cunilingus","cunillingus","cunnilingus","cunt","cunt hair","cuntbag","cuntlick","cuntlicker","cuntlicking","cunts","cuntsicle","cunt-struck","cut rope","cyalis","cyberfuc","cyberfuck","cyberfucked","cyberfucker","cyberfuckers","cyberfucking","d1ck","damn","dick","dick hole","dick shy","dickhead","dildo","dildos","dink","dinks","dirsa","dirty Sanchez","dlck","dog-fucker","doggie style","doggiestyle","doggin","dogging","donkeyribber","doosh","duche","dyke","eat a dick","eat hair pie","ejaculate","ejaculated","ejaculates","ejaculating","ejaculatings","ejaculation","ejakulate","erotic","f u c k","f u c k e r","f_u_c_k","f4nny","facial","fag","fagging","faggitt","faggot","faggs","fagot","fagots","fags","fanny","fannyflaps","fannyfucker","fanyy","fatass","fcuk","fcuker","fcuking","feck","fecker","felching","fellate","fellatio","fingerfuck","fingerfucked","fingerfucker","fingerfuckers","fingerfucking","fingerfucks","fist fuck","fistfuck","fistfucked","fistfucker","fistfuckers","fistfucking","fistfuckings","fistfucks","flange","flog the log","fook","fooker","fuck hole","fuck puppet","fuck trophy","fuck yo mama","fuck","fucka","fuck-ass","fuck-bitch","fucked","fucker","fuckers","fuckhead","fuckheads","fuckin","fucking","fuckings","fuckingshitmotherfucker","fuckme","fuckmeat","fucks","fucktoy","fuckwhit","fuckwit","fudge packer","fudgepacker","fuk","fuker","fukker","fukkin","fuks","fukwhit","fukwit","fux","fux0r","gangbang","gangbang","gang-bang","gangbanged","gangbangs","gassy ass","gaylord","gaysex","goatse","god","god damn","god-dam","goddamn","goddamned","god-damned","ham flap","hardcoresex","hell","heshe","hoar","hoare","hoer","homo","homoerotic","hore","horniest","horny","hotsex","how to kill","how to murdep","jackoff","jack-off","jap","jerk","jerk-off","jism","jiz","jizm","jizz","kawk","kinky Jesus","knob","knob end","knobead","knobed","knobend","knobend","knobhead","knobjocky","knobjokey"};
	

	@Autowired
	@Qualifier("customRestTemplate")
	RestTemplate restemplate;

	// mapping the getProduct() method to /product
	@GetMapping(value = "/startLoadTest")
	public String getProduct() {
		// finds all the products
		startJob();
		// returns the product list
		return "Started";
	}

	@GetMapping(value = "/createPofileTest")
	public String createProfile() {
		// finds all the products
		startJob();
		// returns the product list
		return "Started";
	}

	@Async
	private void startJob() {

		//		List<Product> productList = restemplate.getForObject("http://localhost:9080/product", List.class);
		//		System.out.println(productList);

		ExecutorService executorService = Executors.newFixedThreadPool(10000);
		Runnable runnableTask = () -> {
			List<Product> productList = restemplate.getForObject("http://localhost:9080/product", List.class);
			//System.out.println(productList);
		};

		for (int i = 0; i < 50000; i++) {
			executorService.submit(runnableTask);
		}
	}

	@Async
	private void startCreateProfileTest() {

		//			List<Product> productList = restemplate.getForObject("http://localhost:9080/product", List.class);
		//			System.out.println(productList);

		ExecutorService executorService = Executors.newFixedThreadPool(10000);
		Runnable runnableTask = () -> {
			List<Product> productList = restemplate.getForObject(DEV_URL, List.class);
			//System.out.println(productList);
		};

		for (int i = 0; i < 50000; i++) {
			executorService.submit(runnableTask);
		}


	}
}
