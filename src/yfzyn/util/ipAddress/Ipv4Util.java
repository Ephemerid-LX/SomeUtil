package yfzyn.util.ipAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * ipv4工具类
 */
public class Ipv4Util {
	
	/**
	 * 将InetAddress的ip转换为长整型
	 * @param ipaddr InetAddress ip
	 * @return
	 */
	public static long ipToLong(InetAddress ipaddr){
		byte[] octal = ipaddr.getAddress();
		long loIp = 0;
		for(byte b : octal){
			loIp =  loIp << 8;
			loIp |= b & 0xff;
		}
		return loIp ;
	}
	
	/**
	 * 将合法的字符型ip地址转换未long型
	 * @param ipaddr 字符行ip
	 * @return long型ip
	 */
	public static long ipToLong(String ipaddr){
		long loIp = 0;
		try {
			loIp = ipToLong(InetAddress.getByName(ipaddr));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return loIp;
	}
	
	/**
	 * 将一个长整型数转换为一个ip地址，该长整型数必须是大于16,777,215
	 * 小于4,294,967,296的数
	 * @param loIp
	 * @return
	 */
	public static String longToIp(long loIp){
		String ip1= Long.toString(loIp & 0xff);
		String ip2 = Long.toString((loIp >>> 8) & 0xff);
		String ip3 = Long.toString((loIp >>> 16) & 0xff);
		String ip4 = Long.toString((loIp >>> 24) & 0xff);
		return ip4+ "."+ ip3+ "."+ ip2+"."+ ip1;
	}
	
	/**
	 * 根据指定的ip地址和ip所处的网段，得到该ip所在网络的网络地址的长整型数
	 * @param ip 指定ip的地址
	 * @param netmask 子网掩码
	 * @return 指定ip地址所处网络网络地址的长整型
	 */
	public static long getLongNetworkAddress(String ip, int netmask){
		long loIp = ipToLong(ip);
		long loNetAddr = 
				loIp & ((long)Math.pow(2, (double)netmask)-1) << (32-netmask);
		return loNetAddr;
	}
	
	/**
	 * 根据指定的ip地址和子网掩码，得到该ip所在网络的网络地址 
	 * @param ip 指定ip的地址
	 * @param netmask 子网掩码
	 * @return 指定ip地址所处网络的网络地址
	 */
	public static String getNetworkAddress(String ip, int netmask){
		return longToIp(getLongNetworkAddress(ip, netmask));
	}
	
	
	/**
	 * 根据指定的ip地址和子网掩码，计算ip所在网络广播地址的长整型
	 * @param ip 指定ip地址
	 * @param netmask 子网掩码
	 * @return 指定ip地址所处网络广播地址的长整型
	 */
	public static long getLongBroadcastAddress(String ip, int netmask){
		long longBroadcastAddress = getLongNetworkAddress(ip, netmask) | (long)Math.pow(2, (32-netmask))-1;
		return longBroadcastAddress;
	}
	
	/**
	 * 根据指定的ip地址和子网掩码，计算ip所在网络的广播地址
	 * @param ip 指定ip地址
	 * @param netmask 子网掩码
	 * @return 指定ip地址所处网络广播地址
	 */
	public static String getBroadcastAddress(String ip, int netmask){
		String broadcastAddress= longToIp(getLongBroadcastAddress(ip, netmask));
		return broadcastAddress;
	}
	
	/**
	 * 测试位置
	 */
	@Test
	public void test(){
		System.out.println(ipToLong("123.112.128.12"));
		System.out.println(getNetworkAddress("1.1.1.1", 24));
		System.out.println(getNetworkAddress("192.168.10.129",25));
		System.out.println(longToIp(16777216));
		System.out.println(longToIp(4294967295l));
		System.out.println(getNetworkAddress("192.168.10.64", 27));
		System.out.println(getBroadcastAddress("192.168.10.64", 27));
	}
}