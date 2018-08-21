package com.springboot.dubbo.demo.common.util.geo;

/**
 * 地图帮助类
 * <p>
 *  提供了如下功能：
 *  1. 坐标转换
 *  2. 计算两点间的距离
 * </p>
 *
 * @author 6213
 * @date 2018/6/7
 */
public class GeoUtils {

    //把经纬度转为度（°）
    private static double rad(double d){
        return d * Math.PI / 180.0;
    }

    /**
     * 坐标之间的距离
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return 单位米
     */
    public static double getDistance1(double lat1, double lng1, double lat2, double lng2) {
        lat1 = Math.toRadians(lat1);
        lng1 = Math.toRadians(lng1);
        lat2 = Math.toRadians(lat2);
        lng2 = Math.toRadians(lng2);
        double d1 = Math.abs(lat1 - lat2);
        double d2 = Math.abs(lng1 - lng2);
        double p = Math.pow(Math.sin(d1 / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(d2 / 2), 2);
        double dis = CoordinateConverter.AXIS * 2 * Math.asin(Math.sqrt(p));
        return dis;
    }

    /**
     * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米
     * @param lng1 第一个坐标点的经度
     * @param lat1 第一个坐标点的纬度
     * @param lng2 第二个坐标点的经度
     * @param lat2 第二个坐标点的纬度
     * @return
     */
    public static double getDistance(double lng1, double lat1, double lng2, double lat2){
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(
                Math.sqrt(
                        Math.pow(Math.sin(a/2),2)
                                + Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)
                )
        );
        s = s * CoordinateConverter.AXIS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }

    /**
     * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米
     * @param p1 第一个坐标点的经纬度
     * @param p2 第二个坐标点的经纬度
     * @return
     */
    public static double getDistance(Point p1, Point p2){
        return getDistance(p1.getLon(),p1.getLat(),p2.getLon(),p2.getLat());
    }


    /**
     * test
     * @param args
     */
    /*public static void main(String[] args){
        // 东方科技大厦
        double lng1 = 113.951913;
        double lat1 = 22.553509;
        // 深大地铁口
        double lng2 = 113.951662;
        double lat2 = 22.546199;


        // 得到结果单位为米，距离为800多米
        double distance = getDistance(lng1,lat1,lng2,lat2);
        System.out.println("Distance is:"+distance);
        distance = getDistance1(lat1,lng1,lat2,lng2);
        System.out.println("Distance1 is:"+distance);
        System.out.println("-------------------------------------------");
        Point baiduEnd = new Point();
        baiduEnd.setLat(22.553509);
        baiduEnd.setLon(113.951913);

        Point wgsPoint = new Point();
        wgsPoint.setLat(22.55079);
        wgsPoint.setLon(113.9408);
        System.out.println("wgs：" + wgsPoint.toString());
        Point baiduPoint = convertCoord(wgsPoint,CoordType.EARTH,CoordType.BAIDU);
        System.out.println("baidu：" + baiduPoint.toString());
        distance = getDistance(baiduEnd,wgsPoint);
        System.out.println("Distance2 is:"+distance);
        distance = getDistance(baiduEnd,baiduPoint);
        System.out.println("Distance3 is:"+distance);
    }*/


    // -----------------------------------------------------------------------
    // -------转换坐标 开始-----------------------------------------------------

    /**
     * 从火星坐标系转换为地球坐标系
     *
     * @param marsLat
     * @param marsLon
     * @return
     */
    public static Point convertMars2Earth(double marsLat, double marsLon) {
        double[] p = CoordinateConverter.gcj2WGSExactly(marsLat, marsLon);
        return new Point(p[1], p[0]);
    }

    /**
     * 从火星坐标系转换为地球坐标系
     * @param point
     * @return
     */
    public static Point convertMars2Earth(Point point) {
        return convertMars2Earth(point.getLat(),point.getLon());
    }

    /**
     * 从地球坐标转换为火星坐标,例如:苹果坐标转高德坐标
     *
     * @param earthLat
     * @param earthLon
     * @return
     */
    public static Point convertEarth2Mars(double earthLat, double earthLon) {
        double[] p = CoordinateConverter.wgs2GCJ(earthLat, earthLon);
        return new Point(p[1], p[0]);
    }

    /**
     * 从地球坐标转换为火星坐标,例如:苹果坐标转高德坐标
     *
     * @param p
     * @return
     */
    public static Point convertEarth2Mars(Point p) {
        return convertEarth2Mars(p.getLat(), p.getLon());
    }

    /**
     * 百度坐标转火星坐标
     *
     * @param baiduLat
     * @param baiduLon
     * @return
     */
    public static Point convertBaidu2Mars(double baiduLat, double baiduLon) {
        double[] p = CoordinateConverter.bd092GCJ(baiduLat, baiduLon);
        return new Point(p[1],p[0]);
    }

    /**
     * 百度坐标转火星坐标
     * @param point
     * @return
     */
    public static Point convertBaidu2Mars(Point point) {
        return convertBaidu2Mars(point.getLat(), point.getLon());
    }

    /**
     * 火星坐标转百度坐标
     *
     * @param marsLat
     * @param marsLon
     * @return
     */
    public static Point convertMars2Baidu(double marsLat, double marsLon) {
        double[] p = CoordinateConverter.gcj2BD09(marsLat, marsLon);
        return new Point(p[1],p[0]);
    }

    /**
     * 火星坐标转百度坐标
     * @param point
     * @return
     */
    public static Point convertMars2Baidu(Point point) {
        return convertMars2Baidu(point.getLat(), point.getLon());
    }

    /**
     * 百度坐标转地球坐标
     * @param baiduLat
     * @param baiduLon
     * @return
     */
    public static Point convertBaidu2Earth(double baiduLat, double baiduLon) {
        return convertMars2Earth(convertBaidu2Mars(baiduLat, baiduLon));
    }

    /**
     * 百度坐标转地球坐标
     * @param point 百度坐标
     * @return
     */
    public static Point convertBaidu2Earth(Point point) {
        return convertBaidu2Earth(point.getLat(),point.getLon());
    }

    /**
     * 地球坐标转百度坐标
     * @param earthLat
     * @param earthLon
     * @return
     */
    public static Point convertEarth2Baidu(double earthLat, double earthLon) {
        return convertMars2Baidu(convertEarth2Mars(earthLat, earthLon));
    }

    /**
     * 地球坐标转百度坐标
     * @param point
     * @return
     */
    public static Point convertEarth2Baidu(Point point) {
        return convertEarth2Baidu(point.getLat(), point.getLon());
    }

    /**
     * 图吧坐标转地球坐标
     * @param point
     * @return
     */
    public static Point convertMapbar2Earth(Point point) {
        return convertMapbar2Earth(point.getLat(), point.getLon());
    }

    /**
     *  图吧坐标转地球坐标
     * @param mapbarLat
     * @param mapbarLon
     * @return
     */
    public static Point convertMapbar2Earth(double mapbarLat,double mapbarLon) {
        double[] p = CoordinateConverter.mapBar2WGS84(mapbarLon, mapbarLat);
        return new Point(p[1], p[0]);
    }

    /**
     * 图吧坐标转火星坐标
     * @param point
     * @return
     */
    public static Point convertMapbar2Mars(Point point) {
        return convertMapbar2Mars(point.getLat(), point.getLon());
    }

    /**
     * 图吧坐标转火星坐标
     * @param mapbarLat
     * @param mapbarLon
     * @return
     */
    public static Point convertMapbar2Mars(double mapbarLat,double mapbarLon) {
        return convertEarth2Mars(convertMapbar2Earth(mapbarLat, mapbarLon));
    }

    /**
     * 通用转换接口
     * @param lat
     * @param lon
     * @param from
     * @param to
     * @return
     */
    public static Point convertCoord(double lat, double lon,CoordType from,CoordType to){
        Point result = new Point(lon,lat);
        switch(from){
            case BAIDU:{
                switch(to){
                    case BAIDU:
                        break;
                    case EARTH:
                        result = convertBaidu2Earth(result);
                        break;
                    case MARS:
                        result = convertBaidu2Mars(result);
                        break;
                    case SOGOU:
                        throw new UnsupportedOperationException("Convert From " + from+ " To " + to);
                    case MAPBAR:
                        throw new UnsupportedOperationException("Convert From " + from+ " To " + to);
                    default:
                        throw new UnsupportedOperationException("Convert From " + from+ " To " + to);
                }
                break;
            }
            case EARTH:{
                switch(to){
                    case BAIDU:
                        result = convertEarth2Baidu(result);
                        break;
                    case EARTH:
                        break;
                    case MARS:
                        result = convertEarth2Mars(result);
                        break;
                    case SOGOU:
                        throw new UnsupportedOperationException("Convert From " + from+ " To " + to);
                    case MAPBAR:
                        throw new UnsupportedOperationException("Convert From " + from+ " To " + to);
                    default:
                        throw new UnsupportedOperationException("Convert From " + from+ " To " + to);
                }
                break;
            }
            case MARS:{
                switch(to){
                    case BAIDU:
                        result = convertMars2Baidu(result);
                        break;
                    case EARTH:
                        result = convertMars2Earth(result);
                        break;
                    case MARS:
                        break;
                    case SOGOU:
                        throw new UnsupportedOperationException("Convert From " + from+ " To " + to);
                    case MAPBAR:
                        throw new UnsupportedOperationException("Convert From " + from+ " To " + to);
                    default:
                        throw new UnsupportedOperationException("Convert From " + from+ " To " + to);
                }
                break;
            }
            case SOGOU:{
                throw new UnsupportedOperationException("Convert From " + from+ " To " + to);
            }
            case MAPBAR:{
                switch(to){
                    case BAIDU:
                        break;
                    case EARTH:
                        result = convertMapbar2Earth(result);
                        break;
                    case MARS:
                        result = convertMapbar2Mars(result);
                        break;
                    case SOGOU:
                        throw new UnsupportedOperationException("Convert From " + from+ " To " + to);
                    case MAPBAR:
                        break;
                    default:
                        throw new UnsupportedOperationException("Convert From " + from+ " To " + to);
                }
                break;
            }
            default:{
                throw new UnsupportedOperationException("Convert From " + from+ " To " + to);
            }
        }
        return result;
    }

    /**
     * 通用转换接口
     * @param point
     * @param from
     * @param to
     * @return
     */
    public static Point convertCoord(Point point,CoordType from,CoordType to){
        return convertCoord(point.getLat(), point.getLon(), from, to);
    }
}
