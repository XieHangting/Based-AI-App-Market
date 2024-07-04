import {View, Image} from '@tarojs/components'
import {AtButton} from 'taro-ui'
import Taro from "@tarojs/taro";
import headerBg from "../../asserts/headerBg.png";
import './index.scss'
import GlobalFooter from "../../components/GlobalFooter";


/**
 * 主页
 */
export default () => {
  return (
    <View className='indexPage'>
      <View className='at-article__h1 title' >
        MBTI 人格测试
      </View>
      <View className='at-article__h2 subTitle'>
        只需要3分钟就可以描述你当下的心境和人格
      </View>
      <AtButton
        type='primary'
        circle
        className="enterBtn"
        onClick={()=>{
          Taro.navigateTo({
            url:'/pages/doQuestion/index',
          });
        }}
      >开始测试</AtButton>
      <Image className="headerBg" src={headerBg} />
      <GlobalFooter />
    </View>
  );

};

