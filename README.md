scalaxbとSkinny FrameworkでSOAPに立ち向かう
================================================

[第十四回 #渋谷java](http://shibuya-java.connpass.com/event/25382/)

[スライド](http://nbviewer.jupyter.org/format/slides/github/grimrose/shibuya-java-14/blob/master/scalaxb%20and%20skinny%20framework.ipynb#/)

## サンプルコード

### 対象サービス

SOAP APIを公開しているサービスはこちらを参考にしました。

[PHPでPhotosynthのSOAP APIを呼んでみた](http://am-yu.net/2014/09/27/php_call_photosynth_soap_api/)

対象としたサービスはこちらです。

https://photosynth.net/

SOAP APIの詳細はこちらです。

[PhotosynthService](http://photosynth.net/photosynthws/PhotosynthService.asmx)

WSDLファイルはこちらです。

http://photosynth.net/photosynthws/PhotosynthService.asmx?WSDL

### タスクの実行

```shell
$ activator "runMain TaskRunner ping"
```
