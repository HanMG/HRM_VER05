package kr.co.mghan.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonMethod
{
	// 입력을 받는 버퍼리더 
	public static String input_msg()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try
		{
			input = br.readLine();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return input;
	}
}
