import {View, Image} from '@tarojs/components'
import {AtButton} from 'taro-ui'
import Taro from "@tarojs/taro";
import headerBg from "../../asserts/headerBg.png";
import './index.scss'
import GlobalFooter from "../../components/GlobalFooter";
import questionResults from "../../data/question_results.json"
import {getBestQuestionResult} from "../../utils/bizUtils";
import questions from "../../data/questions.json";

/**
 * 测试结果页面
 */
export default () => {
  // 获取答案
  const answerList = Taro.getStorageSync("answerList");
  if (!answerList || answerList.length < 1) {
    // 展示结果状态
    Taro.showToast({
      title: '答案为空',
      icon: "error",
      duration: 3000,
    });
  }
  // 获取测试结果（bizUtils）
  const result = getBestQuestionResult(answerList, questions, questionResults);

  return (
    <View className='resultPage'>
      <View className='at-article__h1 title'>
        {result.resultName}
      </View>
      <View className='at-article__h2 subTitle'>
        {result.resultDesc}
      </View>
      <AtButton
        type='primary'
        circle className="enterBtn"
        onClick={() => {
          Taro.reLaunch({   // 与navigate不同的是：关闭所有页面，再打开到应用内的某个页面
            url: '/pages/index/index'
          })
        }}
      >返回主页</AtButton>
      <Image className="headerBg" src={headerBg} />
      <GlobalFooter />
    </View>
  );

};

