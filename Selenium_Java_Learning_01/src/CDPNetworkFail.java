import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.fetch.Fetch;
import org.openqa.selenium.devtools.v111.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v111.network.Network;
import org.openqa.selenium.devtools.v111.network.model.ErrorReason;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableList;

public class CDPNetworkFail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver objChromeDriver = new ChromeDriver();
		DevTools objDevTools = objChromeDriver.getDevTools();
		objDevTools.createSession();
		objDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		objDevTools.send(Network.setBlockedURLs(ImmutableList.of("*.png", "*jpg", "*video*")));
		Optional<List<RequestPattern>> patterns = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*search?query*"), Optional.empty(), Optional.empty())));
		objDevTools.send(Fetch.enable(patterns, Optional.empty()));
		objDevTools.addListener(Fetch.requestPaused(), request -> {
			objDevTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
		});
		Long startTime = System.currentTimeMillis();
		objChromeDriver.get("https://www.ae.com");
		WebDriverWait objExpWait = new WebDriverWait(objChromeDriver,Duration.ofSeconds(5));
		objExpWait.until(ExpectedConditions.presenceOfElementLocated(By.id("onetrust-accept-btn-handler")));
		objChromeDriver.findElement(By.id("onetrust-accept-btn-handler")).click();
		objChromeDriver.findElement(By.cssSelector(".sidetray-search")).click();
		objChromeDriver.findElement(By.cssSelector("[name='search']")).sendKeys("w", Keys.ENTER);
		Long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}

}
