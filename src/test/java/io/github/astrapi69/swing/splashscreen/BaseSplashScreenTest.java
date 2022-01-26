/**
 * The MIT License
 *
 * Copyright (C) 2021 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.swing.splashscreen;

import java.util.LinkedHashSet;

import javax.swing.*;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.panels.lottery.LotteryBox;
import io.github.astrapi69.swing.panels.lottery.LotteryPanel;
import io.github.astrapi69.window.adapter.CloseWindow;

public class BaseSplashScreenTest
{

	/**
	 * Test init layout.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args)
	{
		final JFrame frame = new JFrame("Lottery Panel");
		IModel<LotteryBox> lotteryModel;
		lotteryModel = BaseModel.of(LotteryBox.builder().selectedNumbers(new LinkedHashSet<>())
			.minVolume(1).maxVolume(49).rows(7).columns(7).build());
		final LotteryPanel panel = new LotteryPanel(lotteryModel);
		frame.add(panel);
		frame.addWindowListener(new CloseWindow());
		frame.setSize(300, 200);
		String imagePath = "img/xmas/bell.png";
		SplashScreenModelBean splashScreenModelBean = SplashScreenModelBean.builder()
			.imagePath(imagePath).text("BaseSplashScreen example").min(0).max(100).showTime(2000)
			.showing(true).build();
		IModel<SplashScreenModelBean> modelBeanModel = BaseModel.of(splashScreenModelBean);
		new BaseSplashScreen(frame, modelBeanModel);
		frame.setSize(300, 200);
		frame.setVisible(true);
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
		}
		System.exit(0);
	}


}
