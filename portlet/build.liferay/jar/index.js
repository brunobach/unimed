Liferay.Loader.define("unimed_form@0.1.0/index", ['module', 'exports', 'require', './static/js/runtime-main', './static/js/2.chunk', './static/js/main.chunk', './adapt-rt'], function (module, exports, require) {
  var define = undefined;
  var global = window;
  {
    /**
     * This file has been generated by the liferay-js:adapt Yeoman generator. It is
     * the main entry point of the adapted portlet and its responsibility is to load
     * and bootstrap the React application in a way that fits Liferay portlet
     * architecture.
     *
     * This file should be deleted after each `npm run build:liferay` but it isn't 
     * you may delete it safely as it will be recreated and deleted on the next 
     * build.
     */

    // Require webpack bundles generated by create-react-app build.
    var runtime = require("./static/js/runtime-main");
    var two = require("./static/js/2.chunk");
    var main = require("./static/js/main.chunk");

    // Require our adapt runtime support module
    var _ADAPT_RT_ = require("./adapt-rt");

    // Invoke main module passing Liferay's standard entry point arguments.
    module.exports = function (_LIFERAY_PARAMS_) {
      // Load React and runtime engine modules.
      runtime();
      two();

      // Call main
      main(_LIFERAY_PARAMS_, _ADAPT_RT_);
    };
  }
});